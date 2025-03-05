// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class PalindromeOrNot {
    
    // Function to get the middle node of the linked list
    public ListNode getMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // Function to reverse the linked list
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Function to check if the linked list is a palindrome
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;  // A single node or empty list is a palindrome
        }

        // Step 1: Find the middle of the linked list
        ListNode middle = getMiddle(head);

        // Step 2: Reverse the second half of the linked list
        ListNode secondHalfStart = reverse(middle);

        // Step 3: Compare the first half and the reversed second half
        ListNode firstHalfStart = head;
        ListNode secondHalf = secondHalfStart;

        while (secondHalf != null) {
            if (firstHalfStart.val != secondHalf.val) {
                return false;  // Not a palindrome
            }
            firstHalfStart = firstHalfStart.next;
            secondHalf = secondHalf.next;
        }

        // (Optional) Step 4: Restore the original list (if needed)
        reverse(secondHalfStart); // Restore the second half

        return true;  // The list is a palindrome
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
        // Create the linked list: 1 -> 2 -> 3 -> 2 -> 1 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        PalindromeOrNot solution = new PalindromeOrNot();

        System.out.println("Original list:");
        solution.printList(head);

        // Check if the list is a palindrome
        boolean isPalindrome = solution.isPalindrome(head);
        System.out.println("Is the linked list a palindrome? " + isPalindrome);
    }
}
