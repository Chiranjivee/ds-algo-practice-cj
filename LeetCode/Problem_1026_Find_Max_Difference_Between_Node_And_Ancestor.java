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
    public int maxAncestorDiff(TreeNode root) {
        return maxDiff(root, root.val, root.val);
    }
    
    public int maxDiff(TreeNode root, int max, int min) {
        if (root == null) {
            return max - min;
        }
        
        max = Math.max(root.val, max);
        min = Math.min(root.val, min);
        
        return Math.max(maxDiff(root.left, max, min), maxDiff(root.right, max, min));
    }
}
