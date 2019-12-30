class EggDroppingPuzzle {
    // n eggs k floors
    public int eggDropping(int n, int k) {
        int [][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= k; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }

        for (int j = 1; j <= k; j++) {
            dp[1][j] = j;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int a = 1; a <= j; a++) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i - 1][j - 1], dp[i][k - a]));
                }
            }
        }

        return dp[n][k];
    }
}
