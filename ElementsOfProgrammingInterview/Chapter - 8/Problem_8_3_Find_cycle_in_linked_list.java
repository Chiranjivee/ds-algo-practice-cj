class CheckCycle {

    public static ListNode hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null || fastPtr.next != null) {
            if (slowPtr == fastPtr) {
                int cycleLength = 0;
                do {
                    ++cycleLength;
                    slowPtr = slowPtr.next;
                } while (slowPtr != fastPtr);
                ListNode cycleAdvancedPointer = head;
                while (cycleLength-- > 0) {
                    cycleAdvancedPointer = cycleAdvancedPointer.next;
                }
                ListNode iter = head;
                while (iter != cycleAdvancedPointer) {
                    iter = iter.next;
                    cycleAdvancedPointer = cycleAdvancedPointer.next;
                }
                return iter;
            }

            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return null;
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
