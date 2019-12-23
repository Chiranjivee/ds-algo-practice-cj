class EditDistance {

    public int solve(String s1, String s2) {

        int l = s1.length();
        int m = s2.length();

        int [][] dp = new int[l + 1][m + 1];
        
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int j = 0; j <= l; j++) {
            dp[j][0] = j;
        }

        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 2)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[l][m];
    }
}