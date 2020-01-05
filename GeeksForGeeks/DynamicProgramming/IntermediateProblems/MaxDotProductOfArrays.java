class MaxzDotProductOfArrays {
    int solve(int [] arr1, int [] arr2) {
        int n = arr.length;
        int m = arr.length;
        int [][] dp = new int [n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + arr1[j - 1] *  arr2[i - 1], dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }
}
