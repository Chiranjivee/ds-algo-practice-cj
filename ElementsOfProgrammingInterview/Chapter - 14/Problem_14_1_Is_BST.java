class ISBst {
    public static boolean isBST(BSTNode root) {
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBSTHelper(BSTNode root, int lower, int upper) {
        if (root == null) {
            return true;
        } else if (root.data < lower || root.data > upper) {
            return false;
        }

        return 
            isBSTHelper(root.left, lower, root.data) &&
            isBSTHelper(root.right, root.data, upper);
    }

    public static void main(String[] args) {
        BSTNode root = new BSTNode(2);
        BSTNode left = new BSTNode(1);
        BSTNode right = new BSTNode(1);

        root.left = left;
        root.right = right;

        System.out.println(ISBst.isBST(root));
    }
}

class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;
    public BSTNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BSTStatus {
    int previous;
    boolean status;
    public BSTStatus(int previous, boolean status) {
        this.previous = previous;
        this.status = status;
    }
}