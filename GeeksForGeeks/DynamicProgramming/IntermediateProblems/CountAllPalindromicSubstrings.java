class CountAllPalindromicSubstrings {
    public int countAllPalindromicSubstrings(String s) {
        int n = s.length();

        boolean [][] p = new boolean[n][n];
        int [][] dp = new int[n][n];


        for (int i = 0; i < n; i++) {
            p[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                p[i][i + 1] = true;
                dp[i][i + 1] = 1;
            }
        }

        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                int j = gap + i;

                if (s.charAt(i) == s.charAt(j) && p[i + 1][j - 1]) {
                    p[i][j] = true;
                }

                if (p[i][j] == true) {
                    dp[i][j] = 1 + dp[i + 1][j] + dp[i][j + 1] - dp[i + 1][j - 1];
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1] - dp[i + 1][j - 1];
                }
            }
        }

        return dp[0][n - 1];
    }
}
