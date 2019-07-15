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
    public double maximumAverageSubtree(TreeNode root) {
        return helper(root)[2];
    }

    private double[] helper(TreeNode n) {
        if (n == null)  // base case.
            return new double[]{0, 0, 0}; // sum, count  & average of nodes
        double[] l = helper(n.left), r = helper(n.right); // recurse to children.
        double child = Math.max(l[2], r[2]); // larger of the children.
        double sum = n.val + l[0] + r[0], cnt = 1 + l[1] + r[1]; // sum & count of subtree rooted at n.
        double maxOfThree = Math.max(child, sum  / cnt); // largest out of n and its children.
        return new double[]{sum, cnt, maxOfThree}; 
    }
}
