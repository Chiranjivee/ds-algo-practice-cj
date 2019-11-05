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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null) {
            TreeNode curr = queue.poll();
            queue.offer(curr.left);
            queue.offer(curr.right);
        }

        while (!queue.isEmpty() && queue.peek() == null)
            queue.poll();

        return queue.isEmpty();
    }
}
