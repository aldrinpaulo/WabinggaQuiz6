
package quiz.pkg6;


public class LinkedPositionalList<E> implements PositionalList<E> {

    private class Node<E> implements Position<E> {

        private E e;
        private Node<E> prev, next;

        public Node(Node<E> prev, E e, Node<E> next) {
            this.e = e;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public E getElement() throws IllegalStateException {
            return e;
        }

       
        public Node<E> getPrev() {
            return prev;
        }

        
        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

       
        public Node<E> getNext() {
            return next;
        }

      
        public void setNext(Node<E> next) {
            this.next = next;
        }

       
        public void setElement(E e) {
            this.e = e;
        }

    }

    private Node<E> header, trailer;
    private int size;

    public LinkedPositionalList() {
        header = new Node(null, null, null);
        trailer = new Node(header, null, null);
        header.setNext(trailer);
        size = 0;
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Invalid node.");
        }
        Node<E> node = (Node<E>) p;

        if (node.getNext() == null) {
            throw new IllegalArgumentException("Node is not in the list.");
        }

        return node;
    }

    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer) {
            return null;
        }

        Position<E> p = (Position<E>) node;

        return p;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public Position<E> first() {
        return position(header.getNext());
    }

    public Position<E> last() {
        return position(trailer.getPrev());
    }

    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    private Position<E> addBetween(Node<E> prev, E e, Node<E> next) {
        Node<E> newNode = new Node<>(prev, e, next);
        prev.setNext(newNode);
        next.setPrev(newNode);
        size++;
        return position(newNode);
    }
//------------------------------------------------------------------------------

    public Position<E> addFirst(E e) {
        return addBetween(header, e, header.getNext());
    }

    public Position<E> addLast(E e) {
        return addBetween(trailer.getPrev(), e, trailer);
    }

    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(node.getPrev(), e, node);
    }

    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(node, e, node.getNext());
    }
//------------------------------------------------------------------------------

    public E moveToFront(Position<E> p, E e) {
        Node<E> node = validate(p);
        if (node.getNext() != null) {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            size--;
            E temp = p.getElement();
            node.setNext(null);
            node.setPrev(null);
            node.setElement(null);
        }

        return (E) addBetween(header, e, header.getNext());
    }

    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = p.getElement();
        node.setElement(e);
        return temp;
    }

    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        size--;
        E temp = p.getElement();
        node.setNext(null);
        node.setPrev(null);
        node.setElement(null);

        return temp;
    }

    public void showPositionList() {
//        System.out.println(first().getElement());
//        System.out.println(after(first()).getElement());
//        System.out.println(after(after(first())).getElement());
        Position<E> temp = first();
        for (int i = 0; i < size; i++) {
            System.out.print("[" + temp.getElement() + "]");
            temp = after(temp);
        }
    }
}
