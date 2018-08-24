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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) return result;
        addLevel(result, 0, root, false);
        return result;
    }
    
    public void addLevel(List<List<Integer>> result, int level, TreeNode root, boolean rightToLeft) {
        if (root == null) return;
        if (level >= result.size()) {
            result.add(new LinkedList<Integer>());
        }
        if (!rightToLeft) {
            result.get(level).add(root.val);   
        } else {
            LinkedList temp = (LinkedList) result.get(level);
            temp.addFirst(root.val);   
        }
        addLevel(result, level + 1, root.left, !rightToLeft);
        addLevel(result, level + 1, root.right, !rightToLeft);        
    }
}
