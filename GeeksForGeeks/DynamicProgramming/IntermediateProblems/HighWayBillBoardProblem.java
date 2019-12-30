class HighWayBillBoardProblem {
    public int maxRevenue(int [] revenue, int [] x, int m, int t) {

        int [] dp = new int[m + 1];
        int billBoardIdx = 0;

        for (int i = 0; i <= m; i++) {
            if (billBoardIdx < x.length) {
                if (x[billBoardIdx] != i) {
                    dp[i] = dp[i - 1];
                } else {
                    if (i <= t) {
                        dp[i] = Math.max(dp[i - 1], revenue[i]);
                    } else {
                        dp[i] = Math.max(dp[i - 1], revenue[i] + dp[i - 1 - t]);
                    }
                }

                billBoardIdx++;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[m];
    }
}
