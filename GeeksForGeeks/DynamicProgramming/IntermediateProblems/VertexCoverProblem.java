class VertexCover {
    public int vCover(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        if (root.vCover != -1) {
            return root.vCover;
        }

        int excludeRoot = 1 + vCover(root.left) + vCover(root.right);
        int includeRoot = 0;

        if (root.left != null) {
            includeRoot += 1 + vCover(root.left.left) + vCover(root.left.right);
        }

        if (root.right != null) {
            includeRoot += 1 + vCover(root.right.left) + vCover(root.right.right);
        }

        return root.vCover = Math.min(includeRoot, excludeRoot);
    }
}

class TreeNode {
    int data;
    int vCover;
    TreeNode left;
    TreeNode right;
}
