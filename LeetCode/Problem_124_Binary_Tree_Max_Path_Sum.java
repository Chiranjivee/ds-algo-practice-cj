class Solution {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxSum = Integer.MIN_VALUE;
        getMaxPathSum(root);
        return maxSum;
    }
    
    public int getMaxPathSum(TreeNode root) {
        if (root == null) return 0;

        int leftSum = Math.max(0, getMaxPathSum(root.left));
        int rightSum = Math.max(0, getMaxPathSum(root.right));
        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }
}
