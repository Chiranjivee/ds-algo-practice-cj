class PrintLongestPalindromicSubsequence {
    int[][] longestCommonSubsequence(String s1, String s2) {
        int [][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp;
    }

    public void printLongestPalindromicSubsequence(String s) {
        String rev = s.reverse();
        int [][] dp = longestCommonSubsequence(s, s.reverse());
        int m = s.length();
        int n = s.length();

        char [] res = new char[dp[m][n] + 1];
        int index = res.length - 1;

        while (m >= 0 && n >= 0) {
            if (s.charAt(m - 1) == rev.charAt(n - 1)) {
                res[index--] = s.charAt(m - 1);
                m--;
                n--;
            } else if (dp[m - 1][n] > dp[m][n - 1]) {
                m--;
            } else {
                n--;
            }
        }

        System.out.println(res);
    }
}
