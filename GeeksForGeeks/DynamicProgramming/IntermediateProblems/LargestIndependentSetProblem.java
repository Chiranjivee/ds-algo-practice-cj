class LargestIndependentSetProblem {
    public int solve(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int excludeRoot = solve(node.left) + solve(node.right);
        int includeRoot = 1;

        if (root.left != null) {
            includeRoot += solve(node.left.left) + solve(node.left.right);
        }

        if (root.right != null) {
            includeRoot += solve(node.right.left) + solve(node.right.right);
        }

        return Math.max(excludeRoot, includeRoot);
    }

    public int solveDP(TreeNodeDP node) {
        if (node == null) {
            return 0;
        }

        if (node.res != -1) {
            return node.res;
        }

        int excludeRoot = solveDP(node.left) + solveDP(node.right);
        int includeRoot = 1;

        if (root.left != null) {
            includeRoot += solveDP(node.left.left) + solveDP(node.left.right);
        }

        if (root.right != null) {
            includeRoot += solveDP(node.right.left) + solveDP(node.right.right);
        }

        return node.res = Math.max(excludeRoot, includeRoot);
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
}

class TreeNodeDP {
    int data;
    int res = -1;
    TreeNodeDP left;
    TreeNodeDP right;
}
