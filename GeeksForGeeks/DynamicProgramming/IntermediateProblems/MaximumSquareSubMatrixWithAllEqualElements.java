class MaximumSquareSubMatrixWithAllEqualElements {
    static int largestKSubmatrix(int [][] a) {
        int row = a.length;
        int col = a[0].length;
        int [][] dp = new int [row][col]; 
        int result = 0; 
        for (int i = 0; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                if (i == 0 || j == 0) 
                    dp[i][j] = 1; 
  
                else {
                    if (a[i][j] == a[i - 1][j] && a[i][j] == a[i][j - 1] && a[i][j] == a[i - 1][j - 1]) {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }

                result = result > dp[i][j] ? result : dp[i][j];
            }
        }

        return result;
    }
}
