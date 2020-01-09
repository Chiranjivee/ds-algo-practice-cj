class ModifyArrayToMaximizeSumOfAdjacentDifferences {
    static int maximumDifferenceSum(int arr[], int N) {
        // Initialize dp[][] with 0 values. 
        int dp[][] = new int[N][2];
   
        for (int i = 0; i<N; i++)
            dp[i][0] = dp[i][1] = 0;
   
        for (int i = 0; i<(N - 1); i++) {
            /* for [i+1][0] (i.e. current modified value is 1), choose maximum from 
            dp[i][0] + abs(1 - 1) = dp[i][0] and  dp[i][1] + abs(1 - arr[i]) */
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + Math.abs(1 - arr[i]));
   
            /* for [i+1][1] (i.e. current modified value 
            is arr[i+1]), choose maximum from 
            dp[i][0] + abs(arr[i+1] - 1) and 
            dp[i][1] + abs(arr[i+1] - arr[i])*/
            dp[i + 1][1] = Math.max(dp[i][0] + Math.abs(arr[i + 1] - 1), dp[i][1] + Math.abs(arr[i + 1] - arr[i]));
        }
   
        return Math.max(dp[N - 1][0], dp[N - 1][1]);
    }
}