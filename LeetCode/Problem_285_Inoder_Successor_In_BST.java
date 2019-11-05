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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null) return null;
        return successor(root, p);
    }

    private TreeNode successor(TreeNode x, TreeNode p) {
        if (x == null) {
            return null;
        }

        if (p.val < x.val) { // go left
            TreeNode succ = successor(x.left, p); // try to find successor
            if (succ == null) return x;
            else return succ;
        } else {             // p.val >= x.val
            return successor(x.right, p);
        }
    }
}
