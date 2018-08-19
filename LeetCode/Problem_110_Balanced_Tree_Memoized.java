class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalancedUtil(root).isBalanced;
    }
    
    public Data isBalancedUtil(TreeNode root) {
        if (root == null) return new Data(0, true);
        if (root.left == null && root.right == null) return new Data(1, true);
        
        Data leftData = isBalancedUtil(root.left);
        Data rightData = isBalancedUtil(root.right);
        
        return new Data(
            1 + Math.max(leftData.depth, rightData.depth),
            leftData.isBalanced &&
            rightData.isBalanced &&
            Math.abs(leftData.depth - rightData.depth) <= 1);
    }
}
class Data {
    int depth;
    boolean isBalanced;
    Data(int dep, boolean bal) { depth = dep; isBalanced = bal; }
}