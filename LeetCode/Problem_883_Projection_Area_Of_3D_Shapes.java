class Solution {
    public int projectionArea(int[][] grid) {
        int x = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = grid[i][0];
            int max2 = grid[0][i];
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) x++;
                max = Math.max(max, grid[i][j]);
                max2 = Math.max(max2, grid[j][i]);
            }
            x += (max + max2);
        }

        return x;
    }
}