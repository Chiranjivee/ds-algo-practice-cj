import java.util.ArrayList;
import java.util.List;

class GenerateAllBinaryTrees {
    public static List<BinaryTreeNode<Integer>> generateBinaryTrees(int n) {
        List<BinaryTreeNode<Integer>> result = new ArrayList<>();

        if (n == 0) {
            result.add(null);
        }

        for (int numLeftNodes = 0; numLeftNodes < n; numLeftNodes++) {
            int numRightNodes = n - 1 - numLeftNodes;
            List<BinaryTreeNode<Integer>> leftSubTrees = generateBinaryTrees(numLeftNodes);
            List<BinaryTreeNode<Integer>> rightSubTrees = generateBinaryTrees(numRightNodes);

            for (BinaryTreeNode<Integer> left : leftSubTrees) {
                for (BinaryTreeNode<Integer> right: rightSubTrees) {
                    result.add(new BinaryTreeNode(numLeftNodes + 1, left, right));
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<BinaryTreeNode<Integer>> result = generateBinaryTrees(3);
        for (BinaryTreeNode<Integer> node : result) {
            System.out.println(node.data);
        }
    }
}

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data= data;
        this.left = left;
        this.right = right;
    }
}
