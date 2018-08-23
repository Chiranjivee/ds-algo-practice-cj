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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) return result;
        addLevel(result, 0, root);
        Collections.reverse(result);
        return result;
    }
    
    public void addLevel(List<List<Integer>> result, int level, TreeNode root) {
            if (root == null) return;
            if (level >= result.size()) {
                result.add(new LinkedList<Integer>());
            }
            result.get(level).add(root.val);
            addLevel(result, level + 1, root.left);
            addLevel(result, level + 1, root.right);        
    }
}
