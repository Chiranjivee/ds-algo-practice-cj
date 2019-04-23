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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        preorder(root, new HashMap<>(), result);
        return result;
    }
    
    String preorder(TreeNode root, HashMap<String, Integer> map, List<TreeNode> result) {
        if (root == null) return "#";        
        String pre = root.val + preorder(root.left, map, result) + preorder(root.right, map, result);

        if (map.getOrDefault(pre, 0) == 1) result.add(root);
        map.put(pre, map.getOrDefault(pre, 0) + 1);
        return pre;
    }
}
