import java.util.List;
import java.util.ArrayList;

class PascalTriangle {
    /**
     * Time complexity O(n^2)
     * @param rows
     * @return
     */
    public static List<List<Integer>> generatePascal(int rows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                if (pascalTriangle.size() == i) pascalTriangle.add(new ArrayList<>());
                pascalTriangle.get(i).add(
                    0 < j && j < i ? 
                    pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j):
                    1 
                );
            }
        }

        return pascalTriangle;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param n
     * @return
     */
    public static List<Integer> generateNthRow(int n) {
        List<Integer> result = new ArrayList<>();

        result.add(1);
        for (int i = 1; i <= n; i++) {
            result.add(i, (n - i + 1) * result.get(i - 1) / i);
        }

        return result;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param n
     * @return
     */
    public static void generateNthRowInConstantSpace(int n) {
        int last = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(last + " ");
            last = (n - i + 1) * last / i;
        }
        System.out.print(last + " ");
    }
    public static void main(String[] args) {
        int n = 8;
        System.out.println("Row " + n + ": " + PascalTriangle.generateNthRow(n));
        PascalTriangle.generateNthRowInConstantSpace(n);
    }
}
