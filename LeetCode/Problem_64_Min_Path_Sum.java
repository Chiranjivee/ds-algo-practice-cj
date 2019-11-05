class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int dp[][] = new int[row][col];
        
        dp[row - 1][col - 1] = grid[row - 1][col - 1];
        for (int i = col - 2; i >= 0; i--) {
            dp[row - 1][i] = dp[row - 1][i + 1] + grid[row - 1][i];
        }
        
        for (int i = row - 2; i >= 0; i--) {
            dp[i][col - 1] = dp[i + 1][col - 1] + grid[i][col - 1];
        }
        
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }
        
        return dp[0][0];
    }
}
