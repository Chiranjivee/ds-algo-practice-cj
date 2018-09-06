/**
 * Program to implement a binary search tree.
 */
class Solution {
    class BinarySearchTree {
        private Node root;

        public BinarySearchTree() {
            this.root = null;
        }
    
        public Node getRoot() {
            return this.root;
        }

        public void insert(int data) {
            this.root = insert(data, this.getRoot());
        }
        public Node insert(int data, Node root) {
            if (root == null) {
                return new Node(data);
            } else if (root.data > data) {
                root.setLeft(insert(data, root.getLeft()));
            } else {
                root.setRight(insert(data, root.getRight()));
            }
            return root;
        }

        public void delete(int data) {
    
        }

        public void inOrder() {
            inOrder(this.root);
        }

        public void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + ", ");
            inOrder(root.right);
        }
    }

    class Node {
        private int data;
        private Node left;
        private Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public int getData() {
            return this.data;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public void execute() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        bst.inOrder();
    }

    public static void main(String [] args) {
        Solution sol = new Solution();
        sol.execute();
    }
}