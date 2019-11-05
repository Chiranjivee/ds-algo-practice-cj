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
    int x_l = 0, x_r = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        count(root, x);
        return x_r + x_l < n / 2 || x_l > n / 2 || x_r > n / 2;   
    }
    
    
    int count(TreeNode root, int x) {
      if (root == null) return 0;
      int l = count(root.left, x), r = count(root.right, x);
      if (root.val == x) {
        x_l = l;
        x_r = r;   
      }

      return 1 + l + r;
    }
}
