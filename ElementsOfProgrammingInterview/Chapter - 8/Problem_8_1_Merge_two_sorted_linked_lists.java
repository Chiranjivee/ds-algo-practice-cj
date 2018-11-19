class MergeSortedLists {
    public LinkedList mergeLists(LinkedList list1, LinkedList list2) {
        if (list1.head == null && list2.head != null) {
            return list2;
        } else if (list1.head != null && list2.head == null) {
            return list1;
        } else if (list1.head == null && list2.head == null) {
            return list1;
        }

        ListNode pointer1 = list1.head;
        ListNode pointer2 = list2.head;
        LinkedList result = new LinkedList();

        while (pointer1 != null || pointer2 != null) {
            int data1 = pointer1 == null ? Integer.MAX_VALUE : pointer1.data;
            int data2 = pointer2 == null ? Integer.MAX_VALUE : pointer2.data;

            if (data1 < data2) {
                result.addAtEnd(data1);
                pointer1 = pointer1.next;
            } else {
                result.addAtEnd(data2);
                pointer2 = pointer2.next;
            }
        }
        return result;
    }

    public LinkedList mergeListsApproachTwo(LinkedList list1, LinkedList list2) {
        LinkedList result = new LinkedList();
        result.addAtBeginning(-1);
        ListNode dummyHead = result.head;
        ListNode pointer1 = list1.head;
        ListNode pointer2 = list2.head;
        while (pointer1 != null && pointer2 != null) {
            if (pointer1.data < pointer2.data) {
                dummyHead.next = pointer1;
                dummyHead = dummyHead.next;
                pointer1 = pointer1.next;
            } else {
                dummyHead.next = pointer2;
                dummyHead = dummyHead.next;
                pointer2 = pointer2.next;
            }
        }
        
        dummyHead.next = pointer1 == null ? pointer2 : pointer1;
        result.head = result.head.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addAtEnd(1);
        list1.addAtEnd(2);
        list1.addAtEnd(3);
        list1.addAtEnd(4);

        list1.print();

        LinkedList list2 = new LinkedList();
        list2.addAtEnd(5);
        list2.addAtEnd(6);
        list2.addAtEnd(7);
        list2.addAtEnd(8);

        list2.print();

        MergeSortedLists merger = new MergeSortedLists();
        LinkedList result = merger.mergeLists(list1, list2);
        list1.print();
        list2.print();
        result.print();
        
        LinkedList result2 = merger.mergeListsApproachTwo(list1, list2);
        result2.print();

        list1.print();
        list2.print();
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
