class BalancedBinarySearchTree {
    TreeNode root;

    public TreeNode rotateLeft(TreeNode node) {
        TreeNode right = node.right;
        TreeNode rightsLeft = right.left;

        right.left = node;
        node.right = rightsLeft;

        node.height = 1 + 
            Math.max(
                getHeight(node.left), 
                getHeight(node.right));

        right.height = 1 +
            Math.max(
                getHeight(right.left), 
                getHeight(right.right));

        return right;
    }

    public TreeNode rotateRight(TreeNode node) {
        TreeNode left = node.left;
        TreeNode leftsRight = left.right;

        left.right = node;
        node.left = leftsRight;

        node.height = 1 + 
            Math.max(
                getHeight(node.left), 
                getHeight(node.right));

        left.height = 1 +
            Math.max(
                getHeight(left.left), 
                getHeight(left.right));

        return left;
    }

    public int getHeight(TreeNode node) {
        if (node == null) return 0;
        return node.height;
    }

    public void inOrder() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        inOrderUtil(root);
    }

    public void inOrderUtil(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderUtil(root.left);
        System.out.println(root.data + " ");
        inOrderUtil(root.right);
    }

    public void insert(int data) {
        this.root = insertUtil(root, data);
    }

    public TreeNode insertUtil(TreeNode root, int data) {
        if (root == null) {
            TreeNode dataNode = new TreeNode(data);
            return dataNode;
        } else if (root.data < data) {
            root.right = insertUtil(root.right, data);
        } else {
            root.left = insertUtil(root.left, data);
        }

        root.height = 
            1 + Math.max(
                getHeight(root.left), 
                getHeight(root.right));

        int balanceFactor = getBalanceFactor(root);

        if (balanceFactor > 1 && data < root.left.data) {
            root = rotateRight(root);
        } else if (balanceFactor > 1 && data > root.left.data) {
            root.left = rotateLeft(root.left);
            root = rotateRight(root);
        } else if (balanceFactor < -1 && data > root.right.data) {
            root = rotateLeft(root);
        } else if (balanceFactor < -1 && data < root.right.data) {
            root.right = rotateRight(root.right);
            root = rotateLeft(root);
        }

        return root;
    }

    public int getBalanceFactor(TreeNode node) {
        return getHeight(node.left) - getHeight(node.right);
    }

    public void delete(int data) {
        this.root = deleteUtil(root, data);
    }

    public TreeNode deleteUtil(TreeNode root, int data) {
        if (root == null) {
            return null;
        }
        if (root.data < data) {
            root.right = deleteUtil(root.right, data);
        } else if (root.data > data) {
            root.left = deleteUtil(root.left, data);
        } else {
            if (root.left == null && root.right != null) {
                return root.right;
            } else if (root.right == null && root.left != null) {
                return root.left;
            } else if (root.left == null && root.right == null) {
                return null;
            } else {
                TreeNode min = this.getMinInRightSubTree(root.right);
                root.data = min.data;
                root.right = deleteUtil(root.right, min.data);
            }
        }

        root.height = Math.max(getHeight(root.left), getHeight(root.right));
        int balanceFactor = getBalanceFactor(root);

        if (balanceFactor > 1 && getBalanceFactor(root.left) >= 0) {
            root = rotateRight(root);
        } else if (balanceFactor > 1 && getBalanceFactor(root.left) < 0) {
            root.left = rotateLeft(root.left);
            root = rotateRight(root);
        } else if (balanceFactor < -1 && getBalanceFactor(root.right) >= 0) {
            root = rotateLeft(root);
        } else if (balanceFactor < -1 && getBalanceFactor(root.right) < 0) {
            root.right = rotateRight(root.right);
            root = rotateLeft(root);
        }

        return root;
    }

    public TreeNode getMinInRightSubTree(TreeNode rightSubTreeRoot) {
        if (rightSubTreeRoot == null) return null;
        if (rightSubTreeRoot.left == null) return rightSubTreeRoot;
        while (rightSubTreeRoot.left != null) {
            rightSubTreeRoot = rightSubTreeRoot.left;
        }
        return rightSubTreeRoot;
    }

    public static void main(String[] args) {
        BalancedBinarySearchTree avl = new BalancedBinarySearchTree();

        avl.insert(2);
        avl.insert(1);
        avl.insert(3);

        avl.inOrder();

        avl.delete(2);
        avl.inOrder();
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    int height;
    
    TreeNode(int data) {
        this.data = data;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}