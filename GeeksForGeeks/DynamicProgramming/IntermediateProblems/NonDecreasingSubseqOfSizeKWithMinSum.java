class NonDecSubSecSizeKWithMinSum {
    public int solve(int [] arr, int i, int k, int [][] dp) {
        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        if (i < 0) {
            return Integer.MAX_VALUE;
        }
        if (k == 1) {
            return dp[i][k] = findMinInRange(arr, 0, i);
        }

        for (int j = 0; j < i; j++) {
            if (arr[i] >= arr[j]) {
                ans = Math.min(ans, Math.min(solve(arr, j, k, dp), solve(arr, j, k, dp) + arr[i]));    
            } else {
                ans = solve(arr, j, k, dp);
            }
        }

        return dp[i][k] = ans;
    }

    public void solveMain(int [] arr, int k) {
        int [][] dp = new int[arr.length][k + 1];
        return solve(arr, n - 1, k, dp);
    }
}
