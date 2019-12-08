class LongestRepeatedSubsequence {

    int longestRepeatedSubsequence(String s1, String s2) {
        int [][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    int longestCommonSubsequence(String s1, String s2) {
        int [][] dp = new int[s1.length() + 1][s2.length() + 1];

        int i = 0;
        for (int a = 0; a <= s1.length(); a++) {

            // fuck, i love this technique
            i = a & 1;
            for (int j = 0; j <= s2.length(); j++) {
                if (a == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(a - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[1 - i][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[1 - i][j], dp[i][j - 1]);
                }
            }
        }

        return dp[i][s2.length()];
    }
}
