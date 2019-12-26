class ConvertToStrictlyIncreasingIntegerArrayWithMinimumChanges {
    public int solve(int [] arr) {
        int [] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int lis = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }

            lis = Math.max(lis, dp[i]);
        }

        return arr.length - lis;
    }
}
