/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int nodeIdx;
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null) return null;
        return bstFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode bstFromPreorder(int [] preorder, int min, int max) {
        if (nodeIdx == preorder.length || preorder[nodeIdx] < min || preorder[nodeIdx] > max) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[nodeIdx++]);
        root.left = bstFromPreorder(preorder, min, root.val);
        root.right = bstFromPreorder(preorder, root.val, max);
        return root;
    }
}
