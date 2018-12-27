import java.util.List;
import java.util.ArrayList;

class BSTArrays {

    public static List<List<Integer>> findAllBSTArrays(BSTNode root) {
        if (root == null) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        List<List<Integer>> lResult = findAllBSTArrays(root.left);
        List<List<Integer>> rResult = findAllBSTArrays(root.right);

        List<List<Integer>> toReturn = new ArrayList<>();
        for (List<Integer> lList : lResult) {
            for (List<Integer> rList : rResult) {
                toReturn.addAll(interleaveLists(lList, rList));
            }
        }

        for (List<Integer> result: toReturn) {
            result.add(0, root.data);
        }

        return toReturn;
    }

    public static void main(String[] args) {
        BSTNode root = new BSTNode(5);
        BSTNode left = new BSTNode(3);
        BSTNode right = new BSTNode(7);

        BSTNode leftleft = new BSTNode(1);
        BSTNode leftRight = new BSTNode(4);
        left.left = leftleft;
        left.right = leftRight;

        BSTNode rightLeft = new BSTNode(6);
        BSTNode rightRight = new BSTNode(8);

        right.left = rightLeft;
        right.right = rightRight;

        root.left = left;
        root.right = right;

        List<List<Integer>> allArrays = findAllBSTArrays(root);
        System.out.println("Total possible arrays: " + allArrays.size());
        for (List<Integer> temp : allArrays) {
            System.out.println(temp);
        }
    }

    public static List<List<Integer>> interleaveLists(List<Integer> l1, List<Integer> l2) {
        List<List<Integer>> result = new ArrayList<>();
        interleaveListsUtil(l1, l2, new ArrayList<>(), 0, 0, result);
        return result;
    }

    public static void interleaveListsUtil(
        List<Integer> l1, 
        List<Integer> l2, 
        List<Integer> path, 
        int i, 
        int j,
        List<List<Integer>> result) {
        
        if (i == l1.size() && j == l2.size()) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (i < l1.size()) {
            path.add(l1.get(i));
            interleaveListsUtil(l1, l2, path, i + 1, j, result);
            path.remove(path.size() - 1);
        }

        if (j < l2.size()) {
            path.add(l2.get(j));
            interleaveListsUtil(l1, l2, path, i, j + 1, result);
            path.remove(path.size() - 1);
        }
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