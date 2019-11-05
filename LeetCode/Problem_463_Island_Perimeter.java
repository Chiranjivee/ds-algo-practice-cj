class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                res += getPerimeter(grid, i, j);
            }
        }
        return res;
    }
    
    public int getPerimeter(int [][] grid, int i, int j) {
        int res = 0;
        if (j + 1 >= grid[0].length || grid[i][j + 1] == 0) res++;
        if (i + 1 >= grid.length || grid[i + 1][j] == 0) res++;
        if (j - 1 < 0 || grid[i][j - 1] == 0) res++;
        if (i - 1 < 0 || grid[i - 1][j] == 0) res++;
        return res;
    }
}
