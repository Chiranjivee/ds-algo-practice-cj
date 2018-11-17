class IsBinaryTreeBalanced {

    public boolean isBinaryTreeBalanced(TreeNode root) {
        return getBalanceStatus(root).isBalanced;
    }

    public BalanceStatus getBalanceStatus(TreeNode root) {
        if (root == null) {
            return new BalanceStatus(true, 0);
        }
        if (root.left == null && root.right == null) {
            return new BalanceStatus(true, 1);
        }
        
        BalanceStatus left = getBalanceStatus(root.left);
        BalanceStatus right = getBalanceStatus(root.right);

        return new 
            BalanceStatus(
                left.isBalanced && right.isBalanced &&
                Math.abs(left.height - right.height) <= 1, 
                Math.max(left.height, right.height) + 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
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

class BalanceStatus {
    boolean isBalanced;
    int height;
    public BalanceStatus(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}