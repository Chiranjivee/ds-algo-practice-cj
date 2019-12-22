class MinimumCostToFillGivenWeightInBag {
    public int getMinCostToFillBag(int [] cost, int bagSize) {
        int n = cost.length;
        
        int [][] dp = new int[n + 1][bagSize + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= bagSize; j++) {
                if (i == 0) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i + 1 > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - i + 1]) + cost[i - 1];
                    }
                }
            }
        }

        return dp[n][bagSize];
    }
}
