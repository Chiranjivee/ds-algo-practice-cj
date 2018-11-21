import java.util.List;
import java.util.ArrayList;

class NQueens {
    public static List<List<Integer>> nQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        solveNQueens(n, 0, new ArrayList<>(), result);
        return result;
    }

    public static void solveNQueens(int n, int row, List<Integer> colPlacement, List<List<Integer>> result) {
        if (row == n) {
            result.add(colPlacement);
            return;
        }

        for (int i = 0; i < 8; i++) {
            colPlacement.add(i);
            if (isValid(colPlacement)) {
                solveNQueens(n, row + 1, colPlacement, result);
            }
            colPlacement.remove(colPlacement.size() - 1);
        }
    }

    public static boolean isValid(List<Integer> colPlacement) {
        int rowId = colPlacement.size() - 1;
        for (int i = 0; i < rowId; i++) {
            int diff = Math.abs(colPlacement.get(i) - colPlacement.get(rowId));
            if (diff == 0 || diff == rowId - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = nQueens(8);;
        System.out.println(result.size());
    }
}