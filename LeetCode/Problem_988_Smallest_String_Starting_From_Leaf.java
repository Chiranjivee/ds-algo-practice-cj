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
    String result = "";

    public String smallestFromLeaf(TreeNode root) {
        smallestFromLeaf(root, "");
        return result;
    }
    
    public void smallestFromLeaf(TreeNode root, String current) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            current = (char) ('a' + root.val) + "" + current;
            if (result.equals("")) result = current;
            else if (result.compareTo(current) > 0) result = current;
            return;
        }

        char c = (char) ('a' + root.val);
        smallestFromLeaf(root.left, c + "" + current);
        smallestFromLeaf(root.right, c + "" +  current);
    }
    
    private void smallest(TreeNode root, String currPath) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            currPath = (char) (root.val + 'a') + "" + currPath;
            if(result.equals("")) result = currPath;
            else {
                if(result.compareTo(currPath) > 0) result = currPath;
            }
            return;
        }
        smallest(root.left, (char) (root.val + 'a') + "" + currPath);
        smallest(root.right, (char) (root.val + 'a') + "" + currPath);
    }
}
