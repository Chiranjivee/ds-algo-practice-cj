class ProbabilityOfReachingOfPointWith2Or3StepsAtATime {
    public double solve(int n, int p) {
        double [] dp = new double[n + 1];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = p;
        dp[3] = 1 - p;

        for (int i = 4; i <= n; i++) {
            dp[i] = p * dp[i - 2] + (1 - p) * dp[i - 3];
        }

        return dp[n];
    }
}
