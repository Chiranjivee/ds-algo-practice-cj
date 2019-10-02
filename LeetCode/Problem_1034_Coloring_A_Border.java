class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {

        int val = grid[r0][c0];

        // 1.Find out the connected components and mark them -1
        color(grid, r0, c0, val);

        // 2.Among the connected components, find out "non-borders" and mark them -2
        for (int i = 1; i < grid.length - 1; i++)
            for (int j = 1; j < grid[0].length - 1; j++)
                if (grid[i][j] == -1 && (grid[i - 1][j] == -1 || grid[i - 1][j] == -2) && grid[i + 1][j] == -1
                        && (grid[i][j - 1] == -1 || grid[i][j - 1] == -2) && grid[i][j + 1] == -1)
                    grid[i][j] = -2;

        // 3.Color the "borders" and turn "non-borders" back to initial value
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1)
                    grid[i][j] = color;
                if (grid[i][j] == -2)
                    grid[i][j] = val;
            }
        }

        return grid;
    }

    private void color(int[][] grid, int r0, int c0, int val) {
        if (r0 < 0 || c0 < 0 || r0 >= grid.length || c0 >= grid[0].length || grid[r0][c0] != val)
            return;
        grid[r0][c0] = -1;
        color(grid, r0 + 1, c0, val);
        color(grid, r0 - 1, c0, val);
        color(grid, r0, c0 + 1, val);
        color(grid, r0, c0 - 1, val);
    }
}
