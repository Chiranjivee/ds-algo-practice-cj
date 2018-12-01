import java.util.List;
import java.util.ArrayList;

public class InorderWalkWithPredecessor {

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            Integer pred = 
            !list.isEmpty() ? 
            list.get(list.size() - 1) : -1;
            
            System.out.println("Current: " + root.data + ", Pred: " + pred);
            
            list.add(root.data);
            return;
        }
        inOrder(root.left, list);
        Integer pred = list.get(list.size() - 1);
        list.add(root.data);
        System.out.println("Current: " + root.data + ", Pred: " + pred);
        inOrder(root.right, list);
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
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.left = rightLeft;
        right.right= rightRight;
        InorderWalkWithPredecessor pred = new InorderWalkWithPredecessor();

        List<Integer> result = new ArrayList<>();
        pred.inOrder(root, result);
        System.out.println(result);
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
