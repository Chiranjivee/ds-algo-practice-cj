class BinarySearchTree {
    TreeNode root;

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

        return root;
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
            } else {
                TreeNode min = this.getMinInRightSubTree(root.right);
                root.data = min.data;
                root.right = deleteUtil(root.right, min.data);
            }
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
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(2);
        bst.insert(1);
        bst.insert(3);

        bst.inOrder();

        bst.delete(2);
        bst.inOrder();
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}