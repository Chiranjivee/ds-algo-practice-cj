import java.util.Stack;

class Solution {
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class LinkedList {
        Node head;
        public void printList() {
            Node pointer = head;

            while (pointer != null) {
                System.out.print(pointer.data + ", ");
                pointer = pointer.next;
            }
        }

        public void printListInReverse() {
            Node pointer = head;
            Stack<Node> st = new Stack<>();
            while (pointer != null) {
                st.push(pointer);
                pointer = pointer.next;
            }

            while(!st.isEmpty()) {
                Node nod = st.pop();
                System.out.print(nod.data + ", ");
            }
        }
    }

    public void execute() {
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        list.head = node1;
        list.printList();
        System.out.println();
        list.printListInReverse();
    }
    public static void main(String [] args) {
        Solution sol = new Solution();
        sol.execute();
    }
}