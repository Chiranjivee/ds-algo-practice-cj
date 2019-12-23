class MinimumTimeToWriteCharactersUsingInsertDeleteAndCopy {

    public int solve(int n, int insertTime, int removeTime, int copyTime) {

        int [] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i - 1] + insertTime, dp[i / 2] + copyTime);
            } else {
                dp[i] = Math.min(dp[i - 1] + insertTime, dp[(i + 1) / 2] + copyTime + removeTime);
            }
        }

        return dp[n];
    }
}
