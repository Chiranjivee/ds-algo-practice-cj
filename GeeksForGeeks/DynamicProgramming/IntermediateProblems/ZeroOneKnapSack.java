class ZeroOneKnapSack {
    public int knapsack(int [] values, int [] weight, int k) {

        int [][] dp = new int[weight.length + 1][k + 1];

        for (int i = 0; i <= weight.length; i++) {
            for (int j = 0; j <= k; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(value[i - 1] + dp[i - 1][k - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[weight.length][k];
    }
}
