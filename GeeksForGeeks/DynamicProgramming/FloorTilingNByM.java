class FloorTilingNByM {
    public int tileFloor(int n, int m) {
        int [] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            if (i > m) {
                dp[i] = dp[i - 1] + dp[i - m];
            } else if (i < m) {
                dp[i] = 1;           
            } else {
                dp[i] = 2;
            }
        }

        return dp[n];
    }
}
