class Solution {

    int ans;
    int[][] grid;
    int tr, tc;
    int[] dr = new int[]{0, -1, 0, 1};
    int[] dc = new int[]{1, 0, -1, 0};
    int R, C;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;

        int todo = 0;
        int sr = 0, sc = 0;
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] != -1) {
                    todo++;
                }

                if (grid[r][c] == 1) {
                    sr = r;
                    sc = c;
                } else if (grid[r][c] == 2) {
                    tr = r;
                    tc = c;
                }
            }

        ans = 0;
        dfs(sr, sc, todo);
        return ans;
    }

    public void dfs(int r, int c, int todo) {
        todo--;
        if (todo < 0) return;
        if (r == tr && c == tc) {
            if (todo == 0) ans++;
            return;
        }

        grid[r][c] = 3;
        for (int k = 0; k < 4; ++k) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                if (grid[nr][nc] % 2 == 0)
                    dfs(nr, nc, todo);
            }
        }
        grid[r][c] = 0;
    }
}
