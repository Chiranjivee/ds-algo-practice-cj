class MaximumSizeSubsetWithGivenSum {
    public int solve(int [] arr, int sum) {
        int n = arr.length;
        boolean [][] dp = new boolean[sum + 1][n + 1];
        int [][] cnt = new int[sum + 1][n + 1];

        // If sum is 0, then answer is true 
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
            cnt[0][i] = 0;
        }
  
        // If sum is not 0 and set is empty, 
        // then answer is false 
        for (int i = 1; i <= sum; i++) {
            dp[i][0] = false;
            cnt[i][0] = -1;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i][j - 1];
                cnt[i][j] = cnt[i][j - 1];

                if (i >= set[j - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - arr[j - 1]][j - 1];

                    if (dp[i][j]) {
                        cnt[i][j] = Math.max(cnt[i][j - 1], cnt[i - arr[j - 1][j - 1]] + 1);
                    }
                }
            }
        }

        return cnt[sum][n];
    }
}
