class PartitioningAnArraySuchThatSumOfSquareDifferencesIsMinimum {
    public void solve(int [] arr, int k) {
        int n = arr.length;
        int [][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp, Integer.MAX_VALUE);
        }

        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int m = i - 1; m >= 0; m--) {
                    int firstElement = arr[m];
                    int lastElement = arr[i];
                    diff = firstElement - lastElement;
                    diffSq = diff * diff;

                    dp[i][j] = Math.min(dp[i][j], dp[m][j - 1] + diffSq);
                }
            }
        }

        return dp[n][k];
    }
}
