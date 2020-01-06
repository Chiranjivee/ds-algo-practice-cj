class MaximumSumPathInAMatrix {
    static int maxSum(int[][] mat, int n) {

        if (n == 1) {
            return mat[0][0];
        }

        int dp[][] = new int[n][n];
        int maxSum = Integer.MIN_VALUE, max;

        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = mat[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                max = Integer.MIN_VALUE;

                if (((j - 1) >= 0) && (max < dp[i + 1][j - 1]))
                    max = dp[i + 1][j - 1];
                if (((j + 1) < n) && (max < dp[i + 1][j + 1]))
                    max = dp[i + 1][j + 1];

                dp[i][j] = mat[i][j] + max;
            }
        }
 
        for (int j = 0; j < n; j++)
            if (maxSum < dp[0][j])
                maxSum = dp[0][j];

        return maxSum;
    }
}
