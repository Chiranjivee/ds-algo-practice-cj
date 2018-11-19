class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAtEnd(1);
        list.addAtEnd(2);
        list.addAtEnd(3);
        list.addAtEnd(4);
        list.print();
        list.reverse();
        list.print();
    }
}

class LinkedList {
    ListNode head;
    public LinkedList() {
        this.head = null;
    }

    public void reverse() {
        reverse(head).next = null;
    }

    private ListNode reverse(ListNode node) {
        if (node.next == null) {
            this.head = node;
            return node;
        }
        ListNode temp = reverse(node.next);
        temp.next = node;
        return node;
    }

    public void print() {
        if (head == null) {
            System.out.println("List is empty");
        }
        ListNode current = head;
        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("X");
    }

    public void addAtBeginning(int data) {
        ListNode dataNode = new ListNode(data);
        if (head == null) {
            this.head = dataNode;
            return;
        }

        dataNode.next = head;
        head = dataNode;
    }

    public void addAtEnd(int data) {
        ListNode dataNode = new ListNode(data);
        if (head == null) {
            this.addAtBeginning(data);
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = dataNode;
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
