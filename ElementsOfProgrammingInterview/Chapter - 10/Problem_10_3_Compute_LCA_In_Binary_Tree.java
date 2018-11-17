class ComputeLCA {
    public int findLCA(TreeNode root, int left, int right) {
        TreeNode ancestor = findLCAUtil(root, left, right).ancestor;
        if (ancestor == null) {
            System.out.println("No LCA found.");
            return -1;
        }
        return ancestor.data;
    }

    public LCAStatus findLCAUtil(TreeNode root, int left, int right) {
        if (root == null) {
            return new LCAStatus(0, null);
        }

        LCAStatus leftStatus = findLCAUtil(root.left, left, right);
        
        if (leftStatus.numberOfNodesFound == 2) return leftStatus;
        LCAStatus rightStatus = findLCAUtil(root.right, left, right);
        
        if (rightStatus.numberOfNodesFound == 2) return rightStatus;

        int numberOfNodesFound = 
            leftStatus.numberOfNodesFound + 
            rightStatus.numberOfNodesFound + 
            (root.data == left ? 1 : 0) + 
            (root.data == right ? 1 : 0) ;

        return new LCAStatus(numberOfNodesFound, numberOfNodesFound == 2 ? root : null);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftleft = new TreeNode(4);
        TreeNode rightright = new TreeNode(5);

        root.left = left;
        root.right = right;
        right.left = rightright;
        left.right = leftleft;
        ComputeLCA computeLCA = new ComputeLCA();
        System.out.println("LCA of 4 and 5: " + computeLCA.findLCA(root, 4, 6));
    }
}

class LCAStatus {
    int numberOfNodesFound;
    TreeNode ancestor;
    public LCAStatus(int num, TreeNode ancestor) {
        this.numberOfNodesFound = num;
        this.ancestor = ancestor;
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