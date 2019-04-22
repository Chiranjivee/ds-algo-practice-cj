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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        HashMap<TreeNode, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int currW = 0;
        int maxW = Integer.MIN_VALUE;
        
        map.put(root, 1);
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int start = 0;
            int end = 0;
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == 0) start = map.get(node);
                if (i == (levelSize - 1)) end = map.get(node);

                if (node.left != null) {
                    map.put(node.left, map.get(node) * 2);
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    map.put(node.right, map.get(node) * 2 + 1);
                    queue.offer(node.right);
                }
            }
            
            currW = end - start + 1;
            maxW = Math.max(maxW, currW);
        }
        
        return maxW;
    }
}
