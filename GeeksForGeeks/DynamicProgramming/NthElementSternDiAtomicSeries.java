class NthElementSternDiatomicSeries {
    public int getNthElementInSternDiatomicSeries(int n) {

        int [] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[(i - 1) / 2] + dp[(i + 1)/ 2]
            }
        }

        return dp[n];
    }
}
