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
    int closest = 0;
    public int closestValue(TreeNode root, double target) {
        closest = root.val;
        search(root, target);
        return closest;
    }

    public void search(TreeNode root, double target) {        
        if (root==null) {
            return;
        }     
        if (root.val<target) {
            search(root.right, target);
        } else {
            search(root.left, target);
        }

        if (Math.abs(target - root.val)<Math.abs(target-closest)) {
            closest = root.val;
        }
    }
}
