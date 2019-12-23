class MinimumSumMultiplicationOfNNumbers {

    public int sum(int [] arr, int i, int j) {
        int sum = 0;
        for (int a = i; a < j; a++) {
            sum = (sum + arr[a]) % 100;
        }
        return sum;
    }

    public int solve(int [] arr) {
        int n = arr.length;
        int [][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return getMinSumMultiple(arr, dp, 0, n - 1);
    }

    public int getMinSumMultiple(int [] arr, int [][] dp, int i, int j) {
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i == j) {
            return 0;
        }

        dp[i][j] = 100000000;
        for (int k = i; k <= j; k++) {

            dp[i][j] = 
                Math.min(
                    dp[i][j], 
                    getMinSumMultiple(arr, dp, i, k) 
                    + sum(arr, i, k) * sum(arr, k + 1, j)
                    + getMinSumMultiple(arr, dp, k + 1, j));

        }

        return dp[i][j];
    }
}
