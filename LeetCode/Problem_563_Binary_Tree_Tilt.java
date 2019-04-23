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
    public int findTilt(TreeNode root) {
        return findTiltUtil(root)[0];
    }
    
    public int[] findTiltUtil(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        
        int [] left = findTiltUtil(root.left);
        int [] right = findTiltUtil(root.right);
        
        int [] res = new int[2];
        res[0] = Math.abs(left[1] - right[1]) + left[0] + right[0];
        res[1] = root.val + left[1] + right[1];
        return res;
    }
}
