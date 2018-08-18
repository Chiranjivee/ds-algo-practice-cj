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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(result, root);
        return result;
    }
    
    public void inOrder(List<Integer> inOrderList, TreeNode root) {
        if (root == null) {
            return;
        }
        
        inOrder(inOrderList, root.left);
        inOrderList.add(root.val);
        inOrder(inOrderList, root.right);
    }
}
