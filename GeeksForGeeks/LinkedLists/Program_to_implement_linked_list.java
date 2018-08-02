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

        Node newHead = sol.addElementAtBeginning(new Node(5), node1);
        System.out.println();
        sol.printList(newHead);

        sol.addElementAtEnd(new Node(6), newHead);
        System.out.println();
        sol.printList(newHead);
    }

    public Node addElementAtBeginning(Node element, Node head) {
        element.nextNode = head;
	return element;
    }

    public Node addElementAtEnd(Node element, Node head) {
        if (head == null) { 
	    return element;
        }

        Node currentNode = head;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        
        currentNode.nextNode = element;
    	return head;
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
