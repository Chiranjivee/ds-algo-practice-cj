/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }
    
    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}
