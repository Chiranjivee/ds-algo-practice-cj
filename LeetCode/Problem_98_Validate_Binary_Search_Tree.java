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
    public boolean isValidBST(TreeNode root) {
        // for a valid bst in-order traversel should be sorted.
        List<TreeNode> inOrderList = new ArrayList<>();
        inOrder(inOrderList, root);
        
        for (int i = 1; i < inOrderList.size(); i++) {
            if (inOrderList.get(i - 1).val >= inOrderList.get(i).val) {
                return false;
            }
        }
        
        return true;
    }
    
    public void inOrder(List<TreeNode> inOrderList, TreeNode root) {
        if (root == null) {
            return;
        }
        
        inOrder(inOrderList, root.left);
        inOrderList.add(root);
        inOrder(inOrderList, root.right);
    }
}
