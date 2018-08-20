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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversalUtil(root, result);
        return result;
    }
    
    public void postorderTraversalUtil(TreeNode root, List<Integer> postOrder) {
        if (root == null) return;
        
        postorderTraversalUtil(root.left, postOrder);
        postorderTraversalUtil(root.right, postOrder);
        postOrder.add(root.val);
    }
}
