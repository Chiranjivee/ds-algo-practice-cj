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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        
        return isSymmetricUtil(root, root);
    }
    
    public boolean isSymmetricUtil(TreeNode leftMirror, TreeNode rightMirror) {
        if (leftMirror == null && rightMirror == null) return true;
        if (leftMirror == null) return false;
        if (rightMirror == null) return false;
        
        if (leftMirror.val != rightMirror.val) return false;
        
        if (leftMirror.left == null && leftMirror.right == null &&
           rightMirror.left == null && rightMirror.right == null &&
           leftMirror.val == rightMirror.val) return true;
        
        // Do mirrored inorder traversal
        return isSymmetricUtil(leftMirror.left, rightMirror.right) && isSymmetricUtil(leftMirror.right, rightMirror.left);
    }
}
