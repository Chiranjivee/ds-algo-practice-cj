class OverlappingListsWithoutCycles {

    public boolean isOverlapping(LinkedList l1, LinkedList l2) {
        if (l1.head == null || l2.head == null) {
            return false;
        }

        ListNode head1 = l1.head;
        ListNode head2 = l2.head;

        int length1 = getLinkedListLengthFromHead(head1);
        int length2 = getLinkedListLengthFromHead(head2);

        if (length1 > length2) {
            head1 = moveAhead(head1, length1 - length2);
        } else {
            head2 = moveAhead(head1, length2 - length1);
        }

        while (head1 != null || head2 != null) {
            if (head1 == head2) {
                return true;
            }
        }

        return false;
    }

    public ListNode moveAhead(ListNode head, int times) {
        while (times-- > 0) {
            head = head.next;
        }

        return head;
    }

    public int getLinkedListLengthFromHead(ListNode head) {
        if (head == null) return 0;

        int length = 0;
        ListNode current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }

    public static void main(String[] args) {

    }
}

class LinkedList {
    ListNode head;
    public LinkedList() {
        this.head = null;
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
