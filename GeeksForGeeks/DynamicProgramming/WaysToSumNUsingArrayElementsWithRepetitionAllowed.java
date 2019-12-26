class CoinChange {
    public int solve(int [] arr, int n) {
        int [] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j <= n; j++) {
                dp[j] = dp[j - arr[i]];
            }
        }

        return dp[n];
    }
}
