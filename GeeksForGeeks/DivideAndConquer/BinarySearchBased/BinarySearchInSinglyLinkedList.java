class BinarySearchInSinglyLinkedList {
    public int findNode(Node head, int x) {
        Node start = head;
        Node end = null;

        do {
            Node mid = findMidNode(start, end);
            if (mid == null) return null;

            if (mid.data == x) {
                return mid;
            } else if (mid.data > x) {
                end = mid;
            } else {
                start = mid.next;
            }
        } while (end == null || start != end);

        return null;
    }

    public Node findMidNode(Node start, Node end) {
        Node slow = start;
        Node fast = start.next;
        
        while (fast != end) {
            fast = fast.next;
            if (fast.next != end) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        return slow;
    }
}
