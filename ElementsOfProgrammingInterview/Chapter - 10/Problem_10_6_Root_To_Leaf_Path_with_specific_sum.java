import java.util.List;
import java.util.ArrayList;

class RootToLeafSpecificSum {
    public PathSumStatus getSpecificSumPath(TreeNode root, int reqSum) {
        PathSumStatus status = new PathSumStatus();
        if (root == null) {
            return status;
        }
        return getSpecificSumPathUtil(root, status, reqSum); 
    }
    /**
     *  Given tree is :-
     *           1  
     *         2   3
     *        4 5 6 7
     * 
     * @param root
     * @param result
     * @param reqSum
     * @return
     */
    public PathSumStatus getSpecificSumPathUtil(TreeNode root, PathSumStatus status, int reqSum) {
        if (root.left == null && root.right == null && reqSum - root.data == 0) {
            status.result.add(root);
            status.foundSum = true;
            return status;
        }
        if (root.left == null && root.right == null && reqSum - root.data != 0) {
            status.foundSum = false;
            status.result.add(root);
            return status;
        }

        if (reqSum - root.data > 0) {
            status.result.add(root);
        }

        PathSumStatus leftStatus = 
            getSpecificSumPathUtil(
                root.left, 
                status, 
                reqSum - root.data);

        if (leftStatus.foundSum) {
            return leftStatus;
        }

        leftStatus.result.remove(root.left);
        PathSumStatus rightStatus = 
            getSpecificSumPathUtil(
                root.right, 
                status, 
                reqSum - root.data);

        if (rightStatus.foundSum) {
            return rightStatus;
        }

        rightStatus.result.remove(root.right);
        return status;
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
        
        RootToLeafSpecificSum summation = new RootToLeafSpecificSum();
        int reqSum = 8;
        PathSumStatus result = summation.getSpecificSumPath(root, reqSum);
        if (!result.foundSum) {
            System.out.println("No path found with sum: " + reqSum);
            return;
        }
        for (TreeNode node : result.result) {
            System.out.print(node.data + " => ");
        }
        System.out.println("X");
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

class PathSumStatus {
    boolean foundSum;
    List<TreeNode> result;
    public PathSumStatus() {
        this.foundSum = false;
        this.result = new ArrayList<>();
    }
}