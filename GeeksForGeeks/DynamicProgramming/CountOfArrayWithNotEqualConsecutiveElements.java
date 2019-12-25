class CountOfArrayWithNotEqualConsecutive {
    public int getSolve(int n, int k, int x) {

        int [] dp = new int [n];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = (k - 2) * dp[i - 1] + (k - 1) * dp[i - 2];
        }

        return (x == 1) ? (k - 1) * dp[n - 2] : dp[n - 1];
    }
}
