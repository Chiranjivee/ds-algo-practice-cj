class CountDearrangements {
    public int countDearrangements(int n) {
        int [] dp = new [n + 1];

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
        }

        return dp[n];
    }
}
