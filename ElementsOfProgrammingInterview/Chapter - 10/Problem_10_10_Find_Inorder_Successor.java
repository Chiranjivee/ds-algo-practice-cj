class InorderSuccessor {
    public TreeNode findInOrderSuccessor(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        while (node.parent != null && node.parent.right == node) {
            node = node.parent;
        }

        return node.parent;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " -> ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftleft = new TreeNode(4);
        TreeNode rightright = new TreeNode(5);

        root.left = left;
        root.right = right;
        left.parent = root;
        right.parent = root;

        right.left = rightright;
        rightright.parent = right;
        left.right = leftleft;
        leftleft.parent = left;

        InorderSuccessor inOrderSuccessor = new InorderSuccessor();
        inOrderSuccessor.inOrder(root);
        System.out.println("X");
        TreeNode inordersuccessor = inOrderSuccessor.findInOrderSuccessor(leftleft);
        
        if (inordersuccessor == null) {
            System.out.println("Inorder successor not found");
            return;
        }
        System.out.println("Successor for " + leftleft.data + ": " + inordersuccessor.data);
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