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
    public int rangeSumBST(TreeNode root, int L, int R) {
        
        if (root == null) {
            return 0;
        }
        
        int res = 0;
        if (root.val >= L && root.val <= R) {
            res += root.val;
        }
        
        int option1 = rangeSumBST(root.left, L, R);
        int option2 = rangeSumBST(root.right, L, R);
        return res + option1 + option2;
    }
}
