class SummationWays {
    public int getWays(int n, int m) {
        int [] dp = new int[n + 1];
        
        for (int i = m; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                dp[i] += dp[j - i];
            }
        }

        return dp;
    }
}
