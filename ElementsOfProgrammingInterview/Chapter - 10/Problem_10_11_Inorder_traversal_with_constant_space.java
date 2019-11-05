class InorderWithConstantSpace {
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode prev = null;
        TreeNode current = root;
        while (current != null) {
            TreeNode next = null;
            if (current.parent == prev) {
                if (current.left != null) {
                    next = current.left;
                } else {
                    System.out.print(current.data + " -> ");
                    next = current.right != null ? current.right : current.parent;
                }
            } else if (current.left == prev) {
                System.out.print(current.data + " -> ");
                next = current.right != null ? current.right : current.parent;
            } else {
                next = current.parent;
            }

            prev = current;
            current = next;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        left.parent = root;
        right.parent = root;

        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        leftLeft.parent = left;
        leftRight.parent = left;

        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7);
        rightLeft.parent = right;
        rightRight.parent = right;

        root.left = left;
        root.left.left = leftLeft;
        root.left.right = leftRight;

        root.right = right;
        root.right.left = rightLeft;
        root.right.right = rightRight;
        InorderWithConstantSpace in = new InorderWithConstantSpace();
        in.inorder(root);
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}