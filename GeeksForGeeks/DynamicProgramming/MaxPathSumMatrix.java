class MaxPathSumMatrix {
    public int getMaxPathSum(int [][] mat) {

        int row = mat.length;
        int col = mat[0].length;
        int [][] dp = new int [row][col];

        for (int i = 0; i < col; i++) {
            dp[row - 1][i] = mat[row - 1][i];
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + mat[i][j];
                } else if (j == col - 1) {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j - 1]) + mat[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j - 1], Math.max(dp[i + 1][j], dp[i + 1][j + 1])) + mat[i][j];
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < col; i++) {
            res = Math.max(res, dp[0][i);
        }

        return res;
    }
}
