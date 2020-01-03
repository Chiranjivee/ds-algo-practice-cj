class LongestCommonSubsequenceWithKChangesAllowed {
    public int solve(int [][][] dp, int m, int n, int k, String str1, String str2) {
        if (k < 0) {
            return 1000000;
        }

        if (n < 0 || m < 0) {
            return 0;
        }

        if (dp[n][m][k] != -1) {
            return dp[n][m][k];
        }

        ans = 
            Math.max(
                solve(dp, m - 1, n, k, str1, str2),
                solve(dp, m, n - 1, k, str1, str2));

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            ans = Math.max(ans, 1 + solve(dp, m - 1, n - 1, k, str1, str2));
        }

        ans = Math.max(ans, 1 + solve(dp, m - 1, n - 1, k - 1, str1, str2));

        return ans;
    }
}