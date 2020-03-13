class BSTToGreaterSumTree {
    static int sum = 0;
    public void convert(TreeNode root) {
        if (root ==  null) {
            return null;
        }

        convert(root.right);
        sum += root.data;
        root.data = sum - root.data;

        convert(root.left);
    }
}
