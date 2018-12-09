class TilingProblem {

    public static int tiling(int n) {
        int [] memo = new int[n + 1];
        return tilingUtil(n, memo);
    }

    public static int tilingUtil(int n, int [] memo) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (memo[n] != 0) {
            System.out.println("Using memoization for n = " + n);
            return memo[n];
        }

        memo[n] =  tilingUtil(n - 1, memo) + tilingUtil(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println("Tiling 3: " + tiling(48));
    }
}
