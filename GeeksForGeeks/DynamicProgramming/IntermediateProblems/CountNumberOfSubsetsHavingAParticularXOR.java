class CountNumberOfSubsetsHavingAParticularXOR {
    public int countSetsWithXor(int [] arr, int xor) {
        int maxElement = findMax(arr);

        int x = Math.log(maxElement) + 1;
        int m = Math.pow(2, x) - 1;

        int n = arr.length;
        int [][] dp = new int[n + 1][m + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j ^ arr[i - 1]];
            }
        }

        return dp[n][xor];
    }
}
