/**
 * Problem is to tile a n X 2 board with 1 X 2 and 2 X 1 tile.
 * This problem reduces to the fibonacci series. So we could do it optimally in 
 * logn complexity
 */
class TilingProblem {

    public static int solveTilingProblem(int n) {

        if (n == 1 || n == 2) {
            return n;
        }

        // naive sol: please refer to the nth fibonacci solution
        return solveTilingProblem(n - 1) + solveTilingProblem(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("Tiling (45): " + solveTilingProblem(45));
    }
}
