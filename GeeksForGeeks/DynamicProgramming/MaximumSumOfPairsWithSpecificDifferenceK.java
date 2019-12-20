public class MaxSumPairsWithSpecificDifferenceK {
    public int getMaxSumPairsWithSpecificDiffK(int [] arr, int k) {
        Arrays.sort(arr);
        int [] dp = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {
            dp[i] = dp[i - 1];

            if (arr[i] - arr[i - 1] < k) {
                if (i >= 2) {
                    dp[i] = Math.max(dp[i], dp[i - 2] + arr[i] + arr[i - 1]);
                } else {
                    dp[i] = Math.max(dp[i], arr[i] + arr[i - 1]);
                }
            }
        }

        return dp[arr.length - 1];
    }
}
