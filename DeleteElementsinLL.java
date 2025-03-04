import java.util.LinkedList;
import java.util.Iterator;

public class DeleteElementsinLL {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Add elements from 1 to 50 to the LinkedList
        for (int i = 1; i <= 50; i++) {
            list.add(i);
        }

        // Print the original LinkedList
        System.out.println("Original List: " + list);

        // Remove elements greater than 25 using an Iterator
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
            if (value > 25) {
                iterator.remove();  // Remove element if it's greater than 25
            }
        }

        // Print the updated LinkedList
        System.out.println("Updated List (after removing elements > 25): " + list);
    }
}