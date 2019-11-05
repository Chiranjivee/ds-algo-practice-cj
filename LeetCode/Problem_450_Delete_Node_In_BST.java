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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if (root == null) {
            return null;
        }
        
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left != null && root.right != null) {
                // find the inorder successor
                root.val = getMinInRightSubTree(root.right);
                root.right = deleteNode(root.right, root.val);
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
        }
        
        return root;
    }
    
    public int getMinInRightSubTree(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
