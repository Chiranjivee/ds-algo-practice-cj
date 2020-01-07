class MinimumCellsReq {
    static final int SIZE = 100;

    // function to count minimum cells required 
    // to be covered to reach destination 
    static int minCells(int mat[][], int m, int n) {
        // to store min cells required to be 
        // covered to reach a particular cell 
        int dp[][] = new int[m][n];
    
        // initially no cells can be reached 
        for (int i = 0; i<m; i++)
            for (int j = 0; j<n; j++)
                dp[i][j] = Integer.MAX_VALUE;
    
        // base case 
        dp[0][0] = 1;
    
        // building up the dp[][] matrix 
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
    
                // dp[i][j] != INT_MAX denotes that cell 
                // (i, j) can be reached from cell (0, 0) 
                // and the other half of the condition 
                // finds the cell on the right that can 
                // be reached from (i, j) 
                if (dp[i][j] != Integer.MAX_VALUE && (j + mat[i][j]) < n && (dp[i][j] + 1) < dp[i][j + mat[i][j]])
                    dp[i][j + mat[i][j]] = dp[i][j] + 1;
    
                // the other half of the condition finds 
                // the cell right below that can be  
                // reached from (i, j) 
                if (dp[i][j] != Integer.MAX_VALUE && (i + mat[i][j]) < m && (dp[i][j] + 1) < dp[i + mat[i][j]][j])
                    dp[i + mat[i][j]][j] = dp[i][j] + 1;
            }
        }
    
        // it true then cell (m-1, n-1) can be reached 
        // from cell (0, 0) and returns the minimum 
        // number of cells covered 
        if (dp[m - 1][n - 1] != Integer.MAX_VALUE)
            return dp[m - 1][n - 1];
    
        // cell (m-1, n-1) cannot be reached from 
        // cell (0, 0) 
        return -1;
    }
}
