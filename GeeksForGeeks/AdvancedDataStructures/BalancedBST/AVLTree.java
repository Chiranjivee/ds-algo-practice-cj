/**
 * Program to implement a balanced binary search tree (AVL Tree).
 */
class Solution {
    class AVLBinarySearchTree {
        private Node root;

        public AVLBinarySearchTree() {
            this.root = null;
        }
    
        public Node getRoot() {
            return this.root;
        }

        public int getHeight(Node node) {
            if (node == null) return 0;
            return node.getHeight();
        }

        public int getBalanceFactor(Node node) {
            if (node == null) return 0; 
            return 
                this.getHeight(node.getLeft()) -
                this.getHeight(node.getRight());
        }

        public Node rotateRight(Node node) {
            Node prevLeft = node.getLeft();
            Node prevLeftRight = prevLeft.getRight();

            prevLeft.setRight(node);
            node.setLeft(prevLeftRight);

            node.setHeight(
                1 + Math.max(
                    this.getHeight(node.getLeft()),
                    this.getHeight(node.getRight())));
            prevLeft.setHeight(
                1 + Math.max(
                    this.getHeight(prevLeft.getLeft()),
                    this.getHeight(prevLeft.getRight())));

            return prevLeft;
        }

        public Node rotateLeft(Node node) {
            Node prevRight = node.getRight();
            Node prevRightLeft = prevRight.getLeft();

            prevRight.setLeft(node);
            node.setRight(prevRightLeft);

            node.setHeight(
                1 + Math.max(
                    this.getHeight(node.getLeft()),
                    this.getHeight(node.getRight())));

            prevRight.setHeight(
                1 + Math.max(
                    this.getHeight(prevRight.getLeft()),
                    this.getHeight(prevRight.getRight())));

            return prevRight;
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

            root.setHeight(
                1 + Math.max(
                    this.getHeight(root.getLeft()), 
                    this.getHeight(root.getRight())));
            
            int balanceFactor = getBalanceFactor(root);
            if (balanceFactor > 1 && data < root.getLeft().getData()) {
                return rotateRight(root);
            } else if (balanceFactor > 1 && data > root.getLeft().getData()) {
                root.setLeft(rotateLeft(root.getLeft()));
                return rotateRight(root);
            } else if (balanceFactor < -1 && data < root.getRight().getData()) {
                root.setRight(rotateRight(root.getRight()));
                return rotateLeft(root);
            } else if (balanceFactor < -1 && data > root.getRight().getData()) {
                return rotateLeft(root);
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
            inOrderWithFormatting("", this.root);
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

        public void inOrderWithFormatting(String indentation, Node root) {
            if (root == null) {
                System.out.println(indentation + "X");
                return;
            }
            if (root.left == null && root.right == null) {
                System.out.println(indentation + root.data);
                return;
            }
            
            inOrderWithFormatting(indentation + "\t", root.right);
            System.out.println(indentation + root.data);
            inOrderWithFormatting(indentation + "\t", root.left);
        }
    }

    class Node {
        private int data;
        private Node left;
        private Node right;
        private int height;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1;
        }

        public int getData() {
            return this.data;
        }

        public int getHeight() {
            return this.height;
        }
        
        public void setHeight(int height) {
            this.height = height;
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
        AVLBinarySearchTree bst = new AVLBinarySearchTree();
        int [] inp = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < inp.length; i++) {
            System.out.println("===== Insert: " + inp[i] + " ======");
            bst.insert(inp[i]);
            bst.inOrder();
        }
    }

    public static void main(String [] args) {
        Solution sol = new Solution();
        sol.execute();
    }
}