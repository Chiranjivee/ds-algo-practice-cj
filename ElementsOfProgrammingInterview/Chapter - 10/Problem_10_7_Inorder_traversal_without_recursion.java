import java.util.Stack;

class IterativeInorder {
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.data + " -> ");
            current = current.right;
        }
        System.out.println("X");
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7);

        root.left = left;
        root.left.left = leftLeft;
        root.left.right = leftRight;

        root.right = right;
        root.right.left = rightLeft;
        root.right.right = rightRight;
        IterativeInorder inorderIterativeInorder = new IterativeInorder();
        inorderIterativeInorder.inorder(root);
    }
}

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