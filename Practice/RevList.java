class RevList {

    public ListNode reverse(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        if (head.next == null) {
            return head;
        }
        int savedK = k;
        ListNode last = head;
        ListNode current = head.next;
        ListNode next = null;

        while (current != null && --k > 0) {
            // save next
            next = current.next; 

            // insert current at head
            current.next = head;
            head = current;

            // set current next
            last.next = next;
            current = next;
        }

        ListNode dummyHead = head;
        while (last.next != null) {
            ListNode prev = last;
            head = last.next;
            last = head;
            current = head.next;
            next = null;
            
            k = savedK;

            while (current != null && --k > 0) {
                // save next
                next = current.next; 
    
                // insert current at head
                current.next = head;
                head = current;
    
                // set current next
                last.next = next;
                current = next;
            }
            prev.next = head;

        }

        return dummyHead;
    }

    public void print(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " => ");
            current = current.next;
        }
        System.out.println("X");
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode four = new ListNode(4);
        head.next = second;
        second.next = third;
        third.next = four;
        RevList rev = new RevList();
        rev.print(head);
        rev.print(rev.reverse(head, 6));

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