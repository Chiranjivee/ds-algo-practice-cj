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
        }
        else if (root.data > node.data) {
            root.left = insert(root.left, node);
        }
        else {
            root.right = insert(root.right, node);
        }

        return root;
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
        System.out.print(root.data + ", ");
        traverseInorderUtil(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(2);

        bst.traverseInorder();

        bst.insert(1);
        bst.insert(3);

        bst.traverseInorder();
    }
}