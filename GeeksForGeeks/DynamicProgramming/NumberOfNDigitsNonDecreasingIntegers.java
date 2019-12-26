class NumberOfNonDigitsNonDecreasingIntegers {
    public int solve(int n) {
        int [][] dp = new int[n + 1][10];

        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 9; j >= 0; j--) {
                if (j == 9) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j + 1];
                }
            } 
        }

        return dp[n][0];
    }
}
