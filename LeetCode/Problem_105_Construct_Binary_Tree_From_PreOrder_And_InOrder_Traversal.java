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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildTree(
        int [] preorder, int pStart, 
        int [] inorder, int iStart, int iEnd) {
        if (pStart >= preorder.length || iStart > iEnd) {
            return null;
        }
        int val = preorder[pStart];
        TreeNode curr = new TreeNode(val);
        
        // find the number of nodes in the left sub tree;
        int n = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == val) {
                n = i;
                break;
            }
        }
        
        int numNodesInLeftSubTree = n - iStart;
        curr.left = buildTree(preorder, pStart + 1, inorder, iStart, n - 1);
        curr.right = buildTree(preorder, pStart + 1 + numNodesInLeftSubTree , inorder, n + 1, iEnd);
        return curr;
    }
}
