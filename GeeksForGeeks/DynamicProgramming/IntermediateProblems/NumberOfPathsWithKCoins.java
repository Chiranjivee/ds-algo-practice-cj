class NumberOfPathsWithKCoins {
    public int numPaths(int [][] mat, int [][][] dp, int m, int n, int k) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (m == 0 && n == 0) {
            return k == mat[m][n] ? 1 : 0;
        }

        if (dp[m][n][k] != -1) {
            return dp[m][n][k];
        }

        int optionOne = numPaths(mat, dp, m - 1, n, k - mat[m][n]);
        int optionTwo = numPaths(mat, dp, m, n - 1, k - mat[m][n]);

        return dp[m][n][k] = optionOne + optionTwo;
    }
}
