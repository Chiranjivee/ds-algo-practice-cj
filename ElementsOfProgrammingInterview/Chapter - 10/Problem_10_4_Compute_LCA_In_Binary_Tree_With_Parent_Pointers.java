class ComputeLCAByParent {
    public TreeNode findLCA(TreeNode node0, TreeNode node1) {
        int depth0 = depth(node0); // deeper
        int depth1 = depth(node1); 
        if (depth1 > depth0) {
            TreeNode temp = node0;
            node0 = node1;
            node1 = temp;
        }

        while (depth0 != depth1) {
            node1 = node1.parent;
            depth0--;
        }
        while (node0 != node1) {
            node0 = node0.parent;
            node1 = node1.parent;
        }
        return node0;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int depth = 0;
        while (node.parent != null) {
            depth++;
            node = node.parent;
        }
        return depth;
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
        ComputeLCAByParent computeLCA = new ComputeLCAByParent();
        TreeNode lca = computeLCA.findLCA(leftleft, rightright);
        System.out.println("LCA of 4 and 5 : " + lca.data);
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