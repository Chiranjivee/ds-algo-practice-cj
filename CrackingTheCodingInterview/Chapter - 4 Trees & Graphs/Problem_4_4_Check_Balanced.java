/**
 * Problem 4.4
 * 
 * Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined
 * to be a tree such that the heights of the two subtrees of any node
 * never differ by more than one.
 */
class Solution {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    public boolean checkBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.right == null && root.left == null) return true;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int heightDiff = Math.abs(leftHeight - rightHeight);

        return heightDiff < 1 && checkBalanced(root.left) && checkBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
