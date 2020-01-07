class FindMinimumAdjustMentCostOfArray {
    public static int M = 100;

    // Function to find minimum adjustment cost of an array 
    static int minAdjustmentCost(int A[], int n, int target) {
        // dp[i][j] stores minimal adjustment cost on changing 
        // A[i] to j 
        int[][] dp = new int[n][M + 1];

        // handle first element of array separately 
        for (int j = 0; j<= M; j++)
            dp[0][j] = Math.abs(j - A[0]);

        // do for rest elements of the array 
        for (int i = 1; i<n; i++) {
            // replace A[i] to j and calculate minimal adjustment 
            // cost dp[i][j] 
            for (int j = 0; j<= M; j++) {
                // initialize minimal adjustment cost to INT_MAX 
                dp[i][j] = Integer.MAX_VALUE;

                // consider all k such that k >= max(j - target, 0) and 
                // k<= min(M, j + target) and take minimum 
                int k = Math.max(j - target, 0);
                for (; k<= Math.min(M, j + target); k++)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(A[i] - j));
            }
        }

        // return minimum value from last row of dp table 
        int res = Integer.MAX_VALUE;
        for (int j = 0; j<= M; j++)
            res = Math.min(res, dp[n - 1][j]);

        return res;
    }
}
