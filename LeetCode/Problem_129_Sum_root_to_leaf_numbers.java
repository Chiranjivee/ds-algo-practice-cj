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
    public int sumNumbers(TreeNode root) {
        List<Integer> result = pathSum(root);
        return result.stream().mapToInt(Integer::intValue).sum();
    }
    
    public List<Integer> pathSum(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        levelOrder(root, result, 0);
        return result;
    }
    
    public void levelOrder(TreeNode root, List<Integer> result, Integer number) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            number *= 10;
            number += root.val;
            result.add(number);
        }
        
        number *= 10;
        number += root.val;
        
        levelOrder(root.left, result, number);
        levelOrder(root.right, result, number);
    }
}
