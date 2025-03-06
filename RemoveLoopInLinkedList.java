// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveLoopInLinkedList {

    // Function to detect and remove the loop in the linked list
    public void removeLoop(ListNode head) {
        if (head == null || head.next == null) {
            return;  // No loop if list is empty or has only one node
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasLoop = false;

        // Step 1: Detect if there's a loop
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer by 1
            fast = fast.next.next;    // Move fast pointer by 2

            if (slow == fast) {
                hasLoop = true;
                // Loop detected, print the meeting point (first node where slow == fast)
                System.out.println("Loop detected at node with value: " + slow.val);
                break;  // Exit the loop when meeting point is found
            }
        }

        // Step 2: If loop is detected, find the start of the loop
        if (hasLoop) {
            slow = head;  // Reset slow to the head of the list

            // Move both pointers one step at a time to find the start of the loop
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            // Now `slow` (or `fast`) is at the start of the loop
            System.out.println("Start of loop at node with value: " + slow.val);

            // Step 3: Remove the loop
            ListNode loopNode = slow;
            // Move fast to the last node in the loop
            while (fast.next != loopNode) {
                fast = fast.next; 
            }
            fast.next = null; // Remove the loop
        }
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

        RemoveLoopInLinkedList solution = new RemoveLoopInLinkedList();

        // Remove the loop
        solution.removeLoop(head);

        System.out.println("List after removing loop:");
        solution.printList(head);  // Now, it will print the list correctly
    }
}
