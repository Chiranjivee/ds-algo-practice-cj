/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> sumToCount = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        postOrder(root, sumToCount, list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int postOrder(TreeNode root, Map<Integer, Integer> sumToCount, List<Integer> list) {
        if (root == null) {
            return 0;
        }

        int left = postOrder(root.left, sumToCount, list);
        int right = postOrder(root.right, sumToCount, list);
        int currSum = root.val + left + right;
        sumToCount.put(currSum, sumToCount.getOrDefault(currSum, 0) + 1);

        int count = sumToCount.getOrDefault(currSum, 0);
        if (count > max) {
            max = count;
            list.clear();
            list.add(currSum);
        } else if (count == max) {
            list.add(currSum);
        }

        return currSum;
    }
}
