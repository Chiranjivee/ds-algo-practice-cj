class PopulateNextPointerInBinaryTree {

    public void populateNext(Node root, Node next) {
        if (root == null) { 
            return;
        }

        populateNext(root.right, next);
        root.next = next;
        next = root;
        populateNext(root.left, next);
    }
}

class Node {
    int data;
    Node left;
    Node right;
    Node next;
}
