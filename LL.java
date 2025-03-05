public class LL {

    Node head;
    private int size;

    LL() {
        size = 0;
    }

    public class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addInMiddle(int idx, String data) {
        if (idx > size || idx < 0) {
            System.out.println("Invalid index value");
            return;
        }

        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node currNode = head;
        for (int i = 0; i < idx - 1; i++) {
            currNode = currNode.next;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
        size++;
    }

    public void addLast(String data) {
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

    public static void main(String[] args) {

        LL list = new LL();
        list.addLast("is");
        list.addLast("a");
        list.addLast("list");
        list.printList();

        list.addInMiddle(3, "the");

        list.addFirst("this");
        list.printList();
        System.out.println(list.getSize());

        list.removeFirst();
        list.printList();

        list.removeLast();
        list.printList();
    }
}
