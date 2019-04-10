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
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }
    
    public TreeNode bstFromPreorder(int [] preorder, int start, int end) {
        if (start > end || start == -1) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[start]);
        int greaterIdx = -1;
        for (int i = start + 1; i <= end; i++) {
            if (preorder[i] > preorder[start]) {
                greaterIdx = i;
                break;
            }
        }
        
        node.left = bstFromPreorder(preorder, start + 1, greaterIdx == -1 ? end : greaterIdx - 1);
        node.right = bstFromPreorder(preorder, greaterIdx, end);
        return node;
    }
}
