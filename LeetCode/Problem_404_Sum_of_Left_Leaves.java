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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        
        int optionOne = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                optionOne = root.left.val;
            } else {
                optionOne = sumOfLeftLeaves(root.left);
            }
        }
        
        int optionTwo = sumOfLeftLeaves(root.right);
        return optionOne + optionTwo;
    }
}
