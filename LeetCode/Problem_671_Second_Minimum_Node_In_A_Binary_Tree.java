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
    int min = Integer.MAX_VALUE;
    int secMin = Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null) return -1;

        int l = (root.left.val == root.val) ? findSecondMinimumValue(root.left) : root.left.val;
        int r = (root.right.val == root.val) ? findSecondMinimumValue(root.right) : root.right.val;
        return l == -1 || r == -1 ? Math.max(l, r) : Math.min(l, r);
    }
}
