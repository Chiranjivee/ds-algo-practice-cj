class RootToLeafSum {

    public int sum(TreeNode root) {
        if (root == null) return 0;
        return sumUtil(root, 0, 0);
    }

    public int sumUtil(TreeNode root, int sum, int number) {
        if (root.left == null && root.right == null) {
            return sum + number << 1 | root.data;
        }

        return 
            sumUtil(root.left, sum, number << 1| root.data) + 
            sumUtil(root.right, sum, number << 1 | root.data);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(1);


        root.left = left;
        root.right = right;
        
        RootToLeafSum summation = new RootToLeafSum();
        System.out.println(summation.sum(root));
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