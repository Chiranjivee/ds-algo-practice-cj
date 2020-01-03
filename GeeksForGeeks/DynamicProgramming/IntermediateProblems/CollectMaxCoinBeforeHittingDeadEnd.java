class CollectMaxCoinBeforeHittingDeadEnd {
    public int solve(char [][] grid, int [][][] dp, int i, int j, int d) {
        if (grid[i][j] == '#' || isValid(i, j) == false) {
            return 0;
        }

        int result = 0;
        if (grid[i][j] == 'C') {
            result++;
        }

        if (dp[i][j][d] != -1) {
            return dp[i][j][d];
        }

        if (d == 0) {
            return dp[i][j][d] = result + Math.max(solve(grid, dp, i + 1, j, 1), solve(grid, dp, i, j - 1, 0));
        } else {
            return dp[i][j][d] = result + Math.max(solve(grid, dp, i + 1,j, 1), solve(grid, dp, i, j + 1, 0));
        }
    }
}
