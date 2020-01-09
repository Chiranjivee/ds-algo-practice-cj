class MaximizeBinaryMatrix {
    static int cal(int ones[][], int x, int y, int k) {
        return ones[x + k - 1][y + k - 1] - ones[x - 1][y + k - 1] -
            ones[x + k - 1][y - 1] + ones[x - 1][y - 1];
    }
    
    // Return maximum number of 1s after flipping a submatrix  
    static int sol(int mat[][]) {
        int ans = 0;
        int val = 0;
        // Precomputing the number of 1s  
        int ones[][] = new int[R + 1][C + 1];
        for (int i = 1; i<= R; i++)
            for (int j = 1; j<= C; j++) {
                if (mat[i - 1][j - 1] == 1)
                    val = 1;
                ones[i][j] = ones[i - 1][j] + ones[i][j - 1] -
                    ones[i - 1][j - 1] +
                    (val);
            }
        // Finding the maximum number of 1s after flipping  
        for (int k = 1; k<= Math.min(R, C); k++)
            for (int i = 1; i + k - 1<= R; i++)
                for (int j = 1; j + k - 1<= C; j++)
                    ans = Math.max(ans, (ones[R][C] + k * k -
                        2 * cal(ones, i, j, k)));
        return ans;
    }
}
