
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    int size = 0;
    int curr = -1;
    List<Integer> inorder = new ArrayList<>();
    
    
    public BSTIterator(TreeNode root) {
        inorderT(root);
        size = inorder.size();
    }
    
    private void inorderT(TreeNode root) {
        if (root == null) return;
        inorderT(root.left);
        inorder.add(root.val);
        inorderT(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        return inorder.get(++curr);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curr + 1 < size;
    }
}
