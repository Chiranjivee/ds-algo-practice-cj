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
    public int countNodes(TreeNode root) {
        int treeHeight = height(root);
        
        if (treeHeight < 0) {
            return 0;
        }
        
        int rightSubTreeHeight = height(root.right);
        if (rightSubTreeHeight == treeHeight - 1) {
            // This means that the left subtree is a full tree of height
            // treeHeight - 1 
            return (1 << treeHeight) + countNodes(root.right);
        } else {
            return (1 << treeHeight - 1) + countNodes(root.left);
        }
    }
    
    public int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        
        return 1 + height(root.left);
    }
}
