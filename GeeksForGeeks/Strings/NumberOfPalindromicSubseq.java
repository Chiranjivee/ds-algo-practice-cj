class PalindromicSubseq {
    public int getPalindromicSubseqCount(String s) {

        int n = s.length();
        int [][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int gap = 2; gap <= n; gap++) {
            for (int i = 0; i < n; i++) {
                int j = i + gap - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j + 1];
                } else  {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }

        return dp[n][n];
    }
}
