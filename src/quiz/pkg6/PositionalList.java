
package quiz.pkg6;


public interface PositionalList<E> {
    public int size();
    public boolean isEmpty();
    public Position<E> first();
    public Position<E> last();
    public Position<E> before(Position<E> p) throws IllegalArgumentException;
    public Position<E> after(Position<E> p) throws IllegalArgumentException;
    public Position<E> addFirst(E e);
    public Position<E> addLast(E e);
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;
    public E set(Position<E> p, E e) throws IllegalArgumentException;
    public E remove(Position<E> p) throws IllegalArgumentException;
    public E moveToFront(Position<E> p, E e);
}
