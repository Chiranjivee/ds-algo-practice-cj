class MaxNumOfLineSegments {
    public int getMaxLineSegments(int n, int a, int b, int c) {

        int [] denominations = new int [] {a, b, c};
        return countWaysDP(denominations, n);
    }

    public static int countWaysDP(int [] denominations, int N) {
        int [] dp = new int [N + 1];

        dp[0] = 1;
        for (int coinValue : denominations) {
            for (int j = coinValue; j <= N; j++) {
                dp[j] += dp[j - coinValue];
            }
        }

        return dp[N];
    }
}
