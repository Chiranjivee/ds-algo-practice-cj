class PathWithMaxAvgVal {

    /**
     * 
     * Starting from (0, 0) go to (m, n) bottom right. With max avg value;
     * 
     * Avg: Sum of vals / Number of vals;
     * 
     * Here num of vals = (n - 1) + (n - 1) = 2n - 2 moves are required to reach bottom right. + 1 which
     * is the element at (0,0) threrefore 2n - 1
     */
    public double maxAvgValue(int [][] cost) {

        int n = cost.length;
        int [][] dp = new int[n][n];
        dp[0][0] = cost[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = cost[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = cost[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + cost[i][j];
            }
        }

        return dp[n - 1][n - 1] / (2 * n - 1);
    }
}
