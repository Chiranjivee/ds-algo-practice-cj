/**
 * A stable tower of height n is a tower consisting of exactly n tiles of unit 
 * height stacked vertically in such a way, that no bigger tile is placed on a smaller tile.
 * 
 */
class TileStacking {
    int n;
    int k;
    public int solve(int h, int m, int [][] dp) {
        if (dp[h][m] != -1) {
            return d[h][m];
        }

        if (h == n) {
            return dp[h][m] = 1;
        }

        if (m == 0) {
            return dp[h][m] = 0;
        }

        int res = 0;
        for (int i = 0; i < k; i++) {
            res += solve(h + i, m - 1, dp);
        }

        return dp[h][m] = res;
    }
}
