class FindKthInBinaryTree {
    public int findKth(TreeNode root, int k) {
        TreeNode current = root;
        if (root == null) {
            return -1;
        }
        while (current != null) {
            int leftSize = current.left != null ? current.left.size : 0;
            if (leftSize + 1 > k) {
                current = current.left;
            } else if (leftSize == k - 1) {
                return current.data;
            } else {
                k -= leftSize + 1;
                current = current.right;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.size = 7;

        TreeNode left = new TreeNode(2);
        left.size = 3;
        TreeNode right = new TreeNode(3);
        right.size = 3;

        TreeNode leftLeft = new TreeNode(4);
        leftLeft.size = 1;
        TreeNode leftRight = new TreeNode(5);
        leftRight.size = 1;
        TreeNode rightLeft = new TreeNode(6);
        rightLeft.size = 1;
        TreeNode rightRight = new TreeNode(7);
        rightRight.size = 1;

        root.left = left;
        root.left.left = leftLeft;
        root.left.right = leftRight;

        root.right = right;
        root.right.left = rightLeft;
        root.right.right = rightRight;

        FindKthInBinaryTree kth = new FindKthInBinaryTree();
        System.out.println(kth.findKth(root, 3));
    }
}

class TreeNode {
    int data;
    int size;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data) {
        this.size = 0;
        this.data = data;
        this.left = null;
        this.right = null;
    }
}