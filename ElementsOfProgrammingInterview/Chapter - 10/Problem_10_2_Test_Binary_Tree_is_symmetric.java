class BinaryTreeSymmetric {
    
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricUtil(root, root);
    }

    public boolean isSymmetricUtil(TreeNode root, TreeNode root2) {
        if (root == null && root2 == null) {
            return true;
        }
        if (root == null || root2 == null) {
            return false;
        }

        if (root.data != root2.data) {
            return false;
        }

        return 
            isSymmetricUtil(root.left, root2.right) && 
            isSymmetricUtil(root.right, root2.left);
    }

    /**
     *  Tree level 0 =>      1
     *  Tree level 1 =>    2   2
     *  Tree level 2 =>     3 3
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        TreeNode leftleft = new TreeNode(3);
        TreeNode rightright = new TreeNode(3);

        root.left = left;
        root.right = right;
        left.right = leftleft;
        right.left = rightright;

        BinaryTreeSymmetric treeSymmetric = new BinaryTreeSymmetric();
        System.out.println(treeSymmetric.isSymmetric(root));
    }
}

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