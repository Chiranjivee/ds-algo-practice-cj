class UniquePathsWithObstacles {
    public int solve(int [][] grid) {
        int [][] dp = new int[grid.length][grid[0].length];
        int row = grid.length;
        int col = grid[0].length;

        dp[row - 1][col - 1] = 1;
        for (int i = col - 2; i >= 0; i--) {
            if (grid[row - 1][i] == 0) { // if not obstacle
                dp[row - 1][i] = dp[row - 1][i + 1];
            }
        }

        for (int j = row - 2; j >= 0; j--) {
            if (grid[j][col - 1] == 0) { // if not obstacle
                dp[j][col - 1] = dp[j + 1][col - 1];
            }
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
