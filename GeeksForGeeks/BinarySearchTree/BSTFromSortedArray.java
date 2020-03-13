class BSTFromSortedArray {

    public TreeNode getBSTFromSortedArray(int [] array, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(array[mid]);
        rool.left = getBSTFromSortedArray(array, start, mid - 1);
        rool.right = getBSTFromSortedArray(array, mid + 1, end);
        return root;
    }
}
