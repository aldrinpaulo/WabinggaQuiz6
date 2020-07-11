
package quiz.pkg6;

public class Quiz6 {

    public static void main(String[] args) {
        
        // TODO code application logic here
        
        LinkedPositionalList<String> list = new LinkedPositionalList<>();
        Position p1 = list.addFirst("position1");
        Position p2 = list.addAfter(p1, "after position 1");
        Position p3 = list.addBefore(p2, "before p2");
        Position p4 = list.addLast("last position");
      
        
        list.showPositionList();
        
       
        
        list.remove(p2);
        System.out.println();
        list.showPositionList();
        
        
        
        list.moveToFront(p4, "last position");
        System.out.println();
        list.showPositionList();
        
       
        
        System.out.println();
    }
    
}
