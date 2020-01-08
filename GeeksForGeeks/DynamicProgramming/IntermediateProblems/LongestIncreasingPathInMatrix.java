class LongestIncreasingPathInMatrix {
	// Return the length of LIP in 2D matrix 
	static int LIP(int dp[][], int mat[][], int n, int m, int x, int y) {

        // If value not calculated yet. 
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
		
        int result = 0;

        // If reach bottom left cell, return 1. 
        if (x == n - 1 && y == m - 1)
            return dp[x][y] = 1;

        // If reach the corner of the matrix. 
        if (x == n - 1 || y == m - 1)
            result = 1;

        // If value greater than below cell. 
        if (x + 1 < n && mat[x][y] < mat[x + 1][y])
            result = 1 + LIP(dp, mat, n, m, x + 1, y);

        // If value greater than left cell. 
        if (y + 1 < m && mat[x][y] < mat[x][y + 1])
            result = Math.max(result, 1 + LIP(dp, mat, n, m, x, y + 1));

        return dp[x][y] = result;
	}
}
