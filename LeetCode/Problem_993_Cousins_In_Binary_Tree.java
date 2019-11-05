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
    public boolean isCousins(TreeNode root, int x, int y) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            boolean seenX = false;
            boolean seenY = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.removeFirst();
                if (curr.val == x)  seenX = true;
                if (curr.val == y) seenY = true;
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                
                if (curr.left != null && curr.right != null && (curr.left.val == x || curr.left.val == y) && (curr.right.val == x || curr.right.val == y)) {
                    return false;
                }
            }

            if (seenX && seenY) return true;
        }
        return false;
    }
}
