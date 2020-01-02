class ShortestUncommonSubsequence {
    public int shortestUncommonSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int [][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        Arrays.fill(dp[0], 1);
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                char c = s.charAt(i - 1);
                int k;
                for (k = j - 1; k >= 0; j--) {
                    if (t.charAt(k) == c) {
                        break;
                    }
                }

                if (k == -1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i - 1][k]);
                }
            }
        }

        return dp[m][n] == Integer.MAX_VALUE ? -1 : dp[m][n];
    }
}
