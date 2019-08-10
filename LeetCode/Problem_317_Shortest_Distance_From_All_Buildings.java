class Solution {
    private static final int[][] DIRECTIONS = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    
    private static final int BUILDING = 1;
    
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == BUILDING) {
                    bfs(grid, new boolean[m][n], i, j);
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] < 0) {
                    res = Math.min(res, -grid[i][j]);
                }
            }
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private void bfs(int[][] grid, boolean[][] visited, int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startX, startY});
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int[] pos = q.poll();
                
                if (grid[pos[0]][pos[1]] <= 0) {
                    grid[pos[0]][pos[1]] += step;
                }
                for (int[] p : DIRECTIONS) {
                    int x = pos[0] + p[0];
                    int y = pos[1] + p[1];

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                        && grid[x][y] <= 0 && !visited[x][y]) {
                        
                        visited[x][y] = true;
                        q.offer(new int[] {x, y});
                    }
                }
            }
            --step;
        }
        
        // check if any empty land is not reachable
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] <= 0 && !visited[i][j]) {
                    grid[i][j] = 3;
                }
            }
        }
    }
}
