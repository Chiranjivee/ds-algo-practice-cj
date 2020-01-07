class MinimumStepsToDeleteAStringAfterRepeatedDeletionOfPalindromicSubstrings {
    public int solve(int [] arr) {
        int n = arr.length;
        int [][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[j]) {
                dp[i][i + 1] = 1;
            } else {
                dp[i][i + 1] = 2;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j + 1]);
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k], dp[k + 1][j]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
