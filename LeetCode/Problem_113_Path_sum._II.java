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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(root, sum, result, new ArrayList<Integer>());
        return result;
    }
    
    public void levelOrder(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
        if (root == null) return;
        if (root.left == null && root.right == null && sum - root.val == 0) {
            result.add(path);
        }
        
        path.add(root.val);
        List<Integer> leftPath = new ArrayList<>();
        List<Integer> rightPath = new ArrayList<>();
        leftPath.addAll(path);
        rightPath.addAll(path);
        
        levelOrder(root.left, sum - root.val, result, leftPath);
        levelOrder(root.right, sum - root.val, result, rightPath);
    }
}
