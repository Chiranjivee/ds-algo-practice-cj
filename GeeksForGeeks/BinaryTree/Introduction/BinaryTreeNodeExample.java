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

class BinaryTree  {
    TreeNode root;

    public BinaryTree(int rootData) {
        this.root = new TreeNode(rootData);
    }
}
