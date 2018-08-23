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
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        
        flatten(root.left);
        flatten(root.right);
        
        if (root.left == null) return;
        
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        
        TreeNode rightPointer = root.right;
        while (rightPointer.right != null) {
            rightPointer = rightPointer.right;
        }
        
        rightPointer.right = temp;
    }
}
