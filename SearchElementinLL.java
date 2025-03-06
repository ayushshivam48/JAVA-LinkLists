import java.util.*;
public class SearchElementinLL {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        // Add integer elements to the LinkedList
        list.add(1);
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(8);
        list.add(2);
        list.add(3);
 
        // Print the LinkedList
        System.out.println(list);
 
        // Search for element 7
        int target = 7;
        int idx = list.indexOf(target);
 
        // Output result
        if (idx != -1) {
            System.out.println("Element " + target + " found at index: " + idx);
        } else {
            System.out.println("Element " + target + " not found in the list.");
        }
    }
}
