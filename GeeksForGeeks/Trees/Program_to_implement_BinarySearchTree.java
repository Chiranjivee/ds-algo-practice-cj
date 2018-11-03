class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    void insert(int data) {
        TreeNode dataNode = new TreeNode(data);
        this.root = insert(this.root, dataNode);
    }

    TreeNode insert(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        } else if (root.data > node.data) {
            root.left = insert(root.left, node);
        } else {
            root.right = insert(root.right, node);
        }

        return root;
    }

    void contains(int data) {
        boolean isPresent = containsUtil(this.root, data);
        System.out.println("Is " + data + " present: " + isPresent);
    }

    boolean containsUtil(TreeNode root, int data) {
        if (root == null) return false;
        if (root.data < data) {
            return containsUtil(root.right, data);
        } else if (root.data > data) {
            return containUtils(root.left, data);
        }

        return true;        
    }

    void delete(int data) {
        this.root = deleteUtil(root, data);
    }

    TreeNode deleteUtil(TreeNode root, int data) {
        if (root == null) return root;
        if (data < root.data) {
            root.left = deleteUtil(root.left, data);
        } else if (data > root.data) {
            root.right = deleteUtil(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.data = getMinInRightSubTree(root.right);
                root.right = deleteUtil(root.right, root.data);
            }
        }

        return root;
    }

    int getMinInRightSubTree(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    void traverseInorder() {
        traverseInorderUtil(this.root);
        System.out.println();
    }

    void traverseInorderUtil(TreeNode root) {
        if (root == null) {
            return;
        }

        traverseInorderUtil(root.left);
        System.out.print(root.data + " ");
        traverseInorderUtil(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(2);

        bst.traverseInorder();

        bst.insert(1);
        bst.insert(3);

        bst.traverseInorder();

        bst.contains(3);
        bst.contains(4);

        bst.delete(2);
        bst.traverseInorder();
    }
}
