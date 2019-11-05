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
    int runSum = 0;
    public TreeNode bstToGst(TreeNode root) {
        inorder(root);
        return root;
    }
    
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inorder(root.right);
        runSum += root.val;
        root.val = runSum;
        inorder(root.left);
    }
}
