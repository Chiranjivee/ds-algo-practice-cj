class MinimumInitialPointsToReachDestination {
    static int minInitialPoints(int points[][], int R, int C) {
        // dp[i][j] represents the minimum initial points player
        // should have so that when starts with cell(i, j) successfully
        // reaches the destination cell(m-1, n-1)
        int dp[][] = new int[R][C];
        int m = R, n = C;

        // Base case 
        dp[m-1][n-1] = points[m-1][n-1] > 0 ? 1: Math.abs(points[m-1][n-1]) + 1;

        // Fill last row and last column as base to fill 
        // entire table 
        for (int i = m-2; i >= 0; i--)
             dp[i][n-1] = Math.max(dp[i+1][n-1] - points[i][n-1], 1);
        for (int j = n-2; j >= 0; j--)
             dp[m-1][j] = Math.max(dp[m-1][j+1] - points[m-1][j], 1);

        for (int i=m-2; i>=0; i--) {
            for (int j=n-2; j>=0; j--) {
                int min_points_on_exit = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(min_points_on_exit - points[i][j], 1);
            }
        }

        return dp[0][0];
    }
}
