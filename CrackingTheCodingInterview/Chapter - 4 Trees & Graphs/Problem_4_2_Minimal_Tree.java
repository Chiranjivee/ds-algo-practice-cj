/**
 * 
 * Problem 4.2 : Minimal Tree
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm to
 * create a binary search tree with minimal height.
 */
class Solution {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode createMinimalBSTFromSortedArray(int [] array) {
        return createMinimalBSTFromSortedArray(array, 0, array.length - 1);
    }

    public TreeNode createMinimalBSTFromSortedArray(int [] array, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(array[mid]);
        node.left = createMinimalBSTFromSortedArray(array, start, mid - 1);
        node.right = createMinimalBSTFromSortedArray(array, mid + 1, end);
        return node;
    }

    public void execute() {
        int [] input = {1, 2, 3};
        TreeNode tree = createMinimalBSTFromSortedArray(input);
        System.out.println(tree.data);
        System.out.println(tree.left.data);
        System.out.println(tree.right.data);
    }

    public static void main(String [] args) {
        Solution sol = new Solution();
        sol.execute();
    }
}
