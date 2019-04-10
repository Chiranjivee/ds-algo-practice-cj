/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;
        return constructMaximumBinaryTreeUtil(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTreeUtil(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }

        // find the max in range start and end;
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i = start; i <= end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIdx = i;
            }
        }

        TreeNode node = new TreeNode(max);
        node.left = constructMaximumBinaryTreeUtil(nums, start, maxIdx - 1);
        node.right = constructMaximumBinaryTreeUtil(nums, maxIdx + 1, end);
        return node;
    }
}
