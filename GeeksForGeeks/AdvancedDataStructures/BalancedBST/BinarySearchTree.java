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
            this.root = delete(data, this.getRoot());
        }

        public Node delete(int data, Node root) {
            if (root == null) {
                System.out.println("Key not available: " + data);
                return null;
            } 
            if (root.getData() != data && data < root.getData()) {
                root.setLeft(delete(data, root.getLeft()));
            } else if (root.getData() != data && data > root.getData()) {
                root.setRight(delete(data, root.getRight()));
            }

            if (root.getData() == data) {
                if (root.getLeft() == null && root.getRight() == null) {
                    root = null;
                } else if (root.getLeft() == null && root.getRight() != null) {
                    root = root.getRight();
                } else if (root.getRight() == null && root.getLeft() != null) {
                    root = root.getLeft();
                } else {
                    Node inOrderSuccessor = getInOrderSuccessor(root.getRight()); 
                    if (inOrderSuccessor == null) {
                        root = root.getLeft();
                    } else {
                        root.setData(inOrderSuccessor.getData());
                        root.setRight(delete(inOrderSuccessor.getData(), root.getRight()));
                    }
                }
            }

            return root;
        }

        public void inOrder() {
            inOrder(this.root);
        }

        public Node getInOrderSuccessor(Node root) {
            if (root == null) {
                return null;
            } if (root.getRight() == null && root.getLeft() == null) {
                return root;
            }
            Node node = getInOrderSuccessor(root.getLeft());
            return node == null ? root : node;
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

        public void setData(int data) {
            this.data = data;
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
        System.out.println("Insert 3, 2, 1 in bst");
        bst.insert(10);
        bst.insert(15);
        bst.insert(-4);
        bst.insert(18);
        bst.insert(-5);
        bst.insert(0);
        bst.insert(9);
        bst.insert(-18);
        bst.inOrder();

        System.out.println("\nDelete 4");
        bst.delete(4);
        bst.inOrder();
    }

    public static void main(String [] args) {
        Solution sol = new Solution();
        sol.execute();
    }
}