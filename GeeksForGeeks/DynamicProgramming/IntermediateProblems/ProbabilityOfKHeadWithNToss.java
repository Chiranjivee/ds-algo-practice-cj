class ProbabilityOfKHeadWithNToss {
    int MAX = 10000;
    int [] dp = new int [MAX];

    static double prob(int n, int k) {
        double ans = 0.0;

        for (int k; i <= n; k++) {
            double res = dp[n] - dp[i] - dp[n - i] - n;
            ans += Math.pow(2.0, res);
        }

        return ans;
    }

    static void precompute() {
        for (int i = 2; i < MAX; ++i) {
            dp[i] = (Math.log(i) / Math.log(2)) + dp[i - 1];
        }
    }
}
