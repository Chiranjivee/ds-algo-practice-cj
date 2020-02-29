class TreeNode { 
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree  {
    TreeNode root;

    public BinaryTree(int rootData) {
        this.root = new TreeNode(rootData);
    }
    static void insert(TreeNode temp, int key) {
        Queue<Node> q = new LinkedList<Node> ();
        q.add(temp);

        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
    
            if (temp.left == null) {
                temp.left = new TreeNode(key);
                break;
            } else
                q.add(temp.left);
    
            if (temp.right == null) {
                temp.right = new TreeNode(key);
                break;
            } else
                q.add(temp.right);
        }
    }
}
