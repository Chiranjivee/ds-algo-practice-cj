class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        boolean [][] seen = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, area(i, j, grid, seen));
            }
        }
        
        return ans;
    }
    
    public int area(int r, int c, int [][] grid, boolean [][] seen) {
        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            seen[r][c] || grid[r][c] == 0) return 0;
        
        seen[r][c] = true;
        return 
            1 + area(r - 1, c, grid, seen) + 
                area(r + 1, c, grid, seen) + 
                area(r, c - 1, grid, seen) + 
                area(r, c + 1, grid, seen);
    }
}
