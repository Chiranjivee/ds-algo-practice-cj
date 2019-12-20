class MaximumSizeSquareSubMatrixWithAll1s {
    public int getMaxSquareSubMatrix(int [][] mat) {

        int [][] dp = new int [mat.length][mat.length];

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = mat[i][j];
                    continue;
                } else if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }

                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}
