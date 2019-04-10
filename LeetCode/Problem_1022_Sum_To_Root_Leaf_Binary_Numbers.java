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
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        sumRootToLeaf(root, 0);
        return sum;
    }
    
    public void sumRootToLeaf(TreeNode root, int num) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            sum += root.val | (num << 1);
            return;
        }
        
        sumRootToLeaf(root.left, root.val | (num << 1));
        sumRootToLeaf(root.right, root.val | (num << 1));
    }
}
