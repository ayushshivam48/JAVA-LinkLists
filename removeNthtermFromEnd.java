// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class removeNthtermFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        // First, get the size of the linked list
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // If the node to remove is the first node
        if (n == size) {
            return head.next;
        }

        // Find the node before the one we want to remove
        int ptf = size - n;    // position to find
        ListNode prev = head;  // previous node
        int cp = 1;            // current position

        while (cp != ptf) {
            prev = prev.next;
            cp++;
        }

        // Remove the nth node from the end
        prev.next = prev.next.next;
        return head;
    }

    // Utility method to print the list (for testing purposes)
    public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        removeNthtermFromEnd solution = new removeNthtermFromEnd();

        System.out.println("Original list:");
        solution.printList(head);

        
        head = solution.removeNthFromEnd(head, 2);

        System.out.println("Updated list after removing the 2nd node from the end:");
        solution.printList(head);
    }
}
