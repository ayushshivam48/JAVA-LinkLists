public class LL3withRecursion {
    Node head;
    private int size;

    LL3withRecursion() {
        size = 0;
    }

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
        size++;
    }

    public void printList() {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("Empty list, nothing to delete.");
            return;
        }
        head = head.next;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("Empty list, nothing to delete.");
            return;
        }
        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        Node currNode = head;
        Node lastNode = head.next;

        while (lastNode.next != null) {
            currNode = currNode.next;
            lastNode = lastNode.next;
        }
        currNode.next = null;
        size--;
    }

    public int getSize() {
        return size;
    }

    
    public Node reverseListRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;  // Base case: empty or single node list
        }

      
        Node newHead = reverseListRecursive(head.next);

        
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {

        LL3withRecursion list = new LL3withRecursion();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        
        list.printList();

        
        list.head = list.reverseListRecursive(list.head);

        
        list.printList();
    }
}
