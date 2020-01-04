class MaximumProductCutting {
    public int maxProdCutting(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * maxProdCutting(n - i)));
        }

        return res;
    }

    public int maxProdCutting(int n) {
        int [] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]);
            }
        }

        return dp[n];
    }
}
