class ZeroOneKnapSack {
    public void knapsack(int [] values, int [] weight, int k) {

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

        int j = k;
        for (int i = weight.length; i >= 0; i--) {
            if (dp[i][j] == dp[i][j - 1]) {
                // go up
                continue;
            } else {
                System.out.println(weight[i - 1]);
                j -= weight[i - 1];
            }
        }
    }
}
