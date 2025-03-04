// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DetectLoopInLL {
    
    // Function to detect a loop in the linked list
    public boolean detectLoop(ListNode head) {
        if (head == null || head.next == null) {
            return false; // No loop if list is empty or has only one node
        }

        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list with two pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer by 1
            fast = fast.next.next;    // Move fast pointer by 2

            if (slow == fast) {
                return true; // Loop detected
            }
        }

        return false; // No loop detected
    }

    // Utility method to print the list (for testing purposes)
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Creating a loop for testing: connect node 5 to node 3
        head.next.next.next.next.next = head.next.next;

        DetectLoopInLL solution = new DetectLoopInLL();

        // Check if the loop is detected
        boolean hasLoop = solution.detectLoop(head);
        System.out.println("Does the linked list have a loop? " + hasLoop);
    }
}
