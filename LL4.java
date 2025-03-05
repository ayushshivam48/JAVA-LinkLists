import java.util.LinkedList;
import java.util.Collections;

public class LL4 {
     public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);
    }
}
