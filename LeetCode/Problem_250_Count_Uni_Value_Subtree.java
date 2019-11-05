public class Solution {
    int count = 0;
    boolean is_uni(TreeNode node) {
        //base case - if the node has no children this is a univalue subtree
        if (node.left == null && node.right == null) {
            // found a univalue subtree - increment
            count++;
            return true;   
        }

        boolean is_unival = true;

        // check if all of the node's children are univalue subtrees and if they have the same value
        // also recursively call is_uni for children
        if (node.left != null) {
            is_unival = is_uni(node.left) && is_unival && node.left.val == node.val;
         }

        if (node.right != null) {
            is_unival = is_uni(node.right) && is_unival && node.right.val == node.val;
        }

        // return if a univalue tree exists here and increment if it does
        if (!is_unival) return false;
        count++;
        return true;
    }
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        is_uni(root);
        return count;
    }
}
