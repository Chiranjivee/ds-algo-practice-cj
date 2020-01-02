class CountDistinceOccuranceAsSubsequence {
    public int count(String s, String t) {
        int m = t.length();
        int n = s.length();

        if (m > n) {
            return 0;
        }

        int [][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (t.charAt(i - 1) != s.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
