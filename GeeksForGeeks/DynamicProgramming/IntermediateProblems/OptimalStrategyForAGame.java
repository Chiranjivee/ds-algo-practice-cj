class OptimalStrategyForAGame {
    static int optimalStrategyOfGame(int arr[], int n) {
        // Create a table to store solutions of subproblems 
        int table[][] = new int[n][n];
        int gap, i, j, x, y, z;

        for (gap = 0; gap<n; ++gap) {
            for (i = 0, j = gap; j<n; ++i, ++j) {

                x = ((i + 2)<= j) ? table[i + 2][j] : 0;
                y = ((i + 1)<= (j - 1)) ? table[i + 1][j - 1] : 0;
                z = (i<= (j - 2)) ? table[i][j - 2] : 0;
    
                table[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z));
            }
        }
    
        return table[0][n - 1];
    }
}
