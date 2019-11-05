class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAtEnd(1);
        list.addAtEnd(2);
        list.addAtEnd(3);
        list.addAtEnd(4);
        list.addAtEnd(5);
        list.addAtEnd(6);
        list.addAtEnd(7);
        list.addAtEnd(8);
        list.print();
        list.reverse();
        list.print();

        list.reverseSublist(8, 1);
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

    public void reverseSublist(int start, int finish) {
        if (head == null) {
            return;
        }

        ListNode startPrev = null;
        ListNode startNode = head;
        int startIndex = 0;
        int endIndex = 0;

        while (startNode.data != start) {
            startIndex++;
            startPrev = startNode;
            startNode = startNode.next;
        }

        ListNode finishPrev = null;
        ListNode finishNode = head;
        while (finishNode.data != finish) {
            endIndex++;
            finishPrev = finishNode;
            finishNode = finishNode.next;
        }

        if (startNode == null || finishNode == null) {
            return;
        }

        if (startIndex > endIndex) {
            ListNode temp = startNode;
            startNode = finishNode;
            finishNode = temp;
            startPrev = finishPrev;
        }

        ListNode finishNext = finishNode.next;
        reverseSubList(startNode, finishNode, startPrev).next = finishNext;
    }

    private ListNode reverseSubList(ListNode startNode, ListNode finishNode, ListNode startPrev) {
        if (startNode.next == finishNode.next) {
            if (startPrev == null) {
                this.head = startNode;
            } else {
                System.out.println("Start prev:" + startPrev.data);
                startPrev.next = startNode;
            }

            return startNode;
        }
        ListNode temp = reverseSubList(startNode.next, finishNode, startPrev);
        temp.next = startNode;
        return startNode;
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
