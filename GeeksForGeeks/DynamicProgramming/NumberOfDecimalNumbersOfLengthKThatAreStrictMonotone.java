class NumberOfDecimalNumbersOfLengthK {
    public int solve(int k) {

        int [][] dp = new int[k][10];
        for (int i = 0; i <= 9; i++) {
            dp[0][i] = i + 1;
        }

        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= 9; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
            }
        }

        return dp[k - 1][9];
    }
}
