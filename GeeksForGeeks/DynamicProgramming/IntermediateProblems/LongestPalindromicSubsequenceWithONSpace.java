class LongestPalindromicSubsequenceWithONSpace {
    static int lps(String s) {
        int n = s.length();
        int [] dp = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            int backup = 0;
            for (int j = i; j < n; j++) {
                if (j == i) {
                    dp[i] = 1;
                    continue;
                } else if (s.charAt(i) == s.charAt(j)) {
                    int temp = dp[j];
                    dp[j] = 2 + backup;
                    backup = temp;
                } else {
                    backup = dp[j];
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
            }
        }
        return dp[n - 1];
    }
}
