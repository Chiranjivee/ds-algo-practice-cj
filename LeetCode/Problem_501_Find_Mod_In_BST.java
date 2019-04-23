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
    Integer prev = null;
    int count = 1;
    int max = Integer.MIN_VALUE;
    public int[] findMode(TreeNode root) {
        List<Integer> mods = new ArrayList<>();
        inorder(root, mods);
        int [] arr = new int[mods.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = mods.get(i);
        }
        return arr;
        
    }
    
    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        
        
        if (prev != null) {
            if (root.val == prev) {
                count++;
            } else {
                count = 1;
            }
        }

        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }

        prev = root.val;
        inorder(root.right, list);
    }
}
