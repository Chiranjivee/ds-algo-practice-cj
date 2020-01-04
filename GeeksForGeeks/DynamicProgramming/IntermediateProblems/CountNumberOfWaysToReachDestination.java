class CountNumberOfWaysToReachDestination {
    static int countPaths(int [][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int [][] dp = new int[m][n];

        if (mat[m - 1][n - 1] == -1) {
            return 0;
        }

        dp[m - 1][n - 1] = 1;

        // fill the last row
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = mat[m - 1][i] == 0 ? dp[m - 1][i + 1] : 0;
        }

        // fill the last col
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = mat[i][n - 1] == 0 ? dp[i + 1][n - 1] : 0;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (mat[i][j] == -1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
