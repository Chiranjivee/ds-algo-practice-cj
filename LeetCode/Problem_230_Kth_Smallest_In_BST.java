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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrder = new ArrayList<>();
        inorder(root, inOrder);
        return inOrder.get(k - 1) ;
        
    }
    
    public void inorder(TreeNode root, List<Integer> inOrder) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, inOrder);
        inOrder.add(root.val);
        inorder(root.right, inOrder);
    }
}
