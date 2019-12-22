class MinCostPath {
    public int getMinCostPath(int [][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int [][] dp = new int[row][col];

        // fill the last row
        dp[row - 1][col - 1] = mat[row - 1][col - 1];
        for (int i = col - 2; i >= 0; i--) {
            dp[row - 1][i] = dp[row - 1][i + 1] + mat[row - 1][i];
        }

        for (int i = row - 2; i >= 0; i--) {
            dp[i][col - 1] = dp[i + 1][col - 1] + mat[i][col - 1];
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                dp[i][j] = mat[i][j] + Math.min(dp[i + 1][j], Math.max(dp[i + 1][j + 1], dp[i][j + 1]));
            }
        }

        return dp[0][0];
    }
}
