class CountOfStringsThatCanBeFormedABCUnderGivenConstraints {
    public int countString(int [][][] dp, int n, int b, int c) {
        if (b < 0 || c < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (b == 0 && c == 0) {
            return 1;
        }

        if (dp[n][b][c] != -1) {
            return dp[n][b][c];
        }

        int res = countString(dp, n - 1, b, c);
        res += countString(dp, n - 1, b - 1, c);
        res += countString(dp, n - 1, b, c - 1);

        return dp[n][b][c] = res;
    }
}
