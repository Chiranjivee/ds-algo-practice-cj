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
    int mx = 0;
    public int longestUnivaluePath(TreeNode root) {
        longestUniValPathUtil(root);
        return mx == 0 ? 0 : mx;
    }
    
    public int longestUniValPathUtil(TreeNode root) {
        if (root == null) return 0;
        
        
        int left = longestUniValPathUtil(root.left);
        int right = longestUniValPathUtil(root.right);
        
        
        int res1 = 0;
        if (root.left != null) {
            if (root.val == root.left.val) {
                res1 = 1 + left;
            }
        }
        
        int res2 = 0;
        if (root.right != null) {
            if (root.val == root.right.val) {
                res2 = 1 + right;
            }
        }

        mx = Math.max(mx, res1 + res2);
        return Math.max(res1, res2);
    }
}
