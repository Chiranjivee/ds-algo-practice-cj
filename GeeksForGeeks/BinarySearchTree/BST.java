class BST {
    Node root;

    public Node search(Node root, int key) {
        if (root.data == key) {
            return root;
        }

        if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (root.data < key) {
            root.right = insert(root.right, key);
        } else {
            root.left = insert(root.left, key);
        }

        return root;
    }
}

class Node {
    int data;
    Node left;
    Node right;
}
