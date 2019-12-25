class CountWaysToDivideCircleUsingNNonIntersectingChords {
    public int solve(int n) {

        int points = 2 * n;

        int [] dp = new int[points + 1];
        dp[0] = 1;
        dp[2] = 1;

        for (int i = 4; i <= points; i += 2) {
            for (int j = 0; j < i - 1; j += 2) {
                dp[i] += dp[j] * dp[i - 2 - j];
            }
        }

        return dp[points];
    }
}