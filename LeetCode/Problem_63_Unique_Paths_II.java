import java.util.Arrays;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int [][] dp = new int[rows][cols];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return util(obstacleGrid, 0, 0, rows, cols, dp);
    }
    
    public int util(int [][] grid, int m, int n, int rows, int cols, int [][] dp) {
        if (m >= rows || n >= cols) {
            return 0;
        }
        
        if (m == rows - 1 && n == cols - 1 && grid[m][n] == 0) {
            return dp[m][n] = 1;
        }
        
        
        if (grid[m][n] == 1) {
            return dp[m][n] = 0;
        }
        
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        
        int optionOne = util(grid, m, n + 1, rows, cols, dp);
        int optionTwo = util(grid, m + 1, n, rows, cols, dp);
        return dp[m][n] = optionOne + optionTwo;
    }
}
