class Solution {
    public int longestRepeatingSubstring(String S) {
        int n = S.length();

        //dp[i][j] means # of repeated chars for substrings ending at i and j
        int[][] dp = new int[n + 1][n + 1];
        
        int res = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (S.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
