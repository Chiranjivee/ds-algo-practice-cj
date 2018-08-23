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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        levelOrder(root, result, new StringBuilder());
        return result;
    }
    
    public void levelOrder(TreeNode root, List<String> result, StringBuilder builder) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            builder.append(root.val);
            result.add(builder.toString());
        }
        
        builder.append(root.val + "->");
        StringBuilder leftPath = new StringBuilder(builder.toString());
        StringBuilder rightPath = new StringBuilder(builder.toString());

        levelOrder(root.left, result, leftPath);
        levelOrder(root.right, result, rightPath);
    }
}
