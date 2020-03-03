class Solution {
    static int idx = 0;
    public void replaceWithInorderPredAndSuccessor(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        inorder.add(0);
        store(root);
        inorder.add(0);
        idx = 1;
    }

    public void replace(TreeNode root) {
        if (root == null) return;
        replace(root.left);
        root.data = inorder.get(idx - 1) + inorder.get(idx + 1);
        idx++
        replace(root.right);
    }

    public void store(TreeNode root) {
        if (root == null) {
            return;
        }

        store(root.left);
        inorder.add(root.data);
        store(root.right);
    }
}
