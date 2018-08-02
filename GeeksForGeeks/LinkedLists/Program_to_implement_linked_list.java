class Solution {
    static class Node {
        int data;
        Node nextNode;
 
        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }
    
    public static void main(String [] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        
	node1.nextNode = node2;
	node2.nextNode = node3;
	node3.nextNode = node4;
        Solution sol = new Solution();
        sol.printList(node1);
    }

    public void printList(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " => ");
            currentNode = currentNode.nextNode;
        }

        System.out.print("X");
    }
}
