class MinimumSumPathIn3DArray {
    static int minPathSum(int arr[][][]) {
        int i, j, k;
        int tSum[][][] =new int[l][m][n];

        tSum[0][0][0] = arr[0][0][0];
        /* Initialize first row of tSum array */
        for (i = 1; i < l; i++)
            tSum[i][0][0] = tSum[i-1][0][0] + arr[i][0][0];

        /* Initialize first column of tSum array */
        for (j = 1; j < m; j++)
            tSum[0][j][0] = tSum[0][j-1][0] + arr[0][j][0];

        /* Initialize first width of tSum array */
        for (k = 1; k < n; k++)
            tSum[0][0][k] = tSum[0][0][k-1] + arr[0][0][k];

        /* Initialize first row- First column of 
            tSum array */
        for (i = 1; i < l; i++)
            for (j = 1; j < m; j++)
                tSum[i][j][0] = min(tSum[i-1][j][0], tSum[i][j-1][0], Integer.MAX_VALUE) + arr[i][j][0];

        /* Initialize first row- First width of 
            tSum array */
        for (i = 1; i < l; i++)
            for (k = 1; k < n; k++)
                tSum[i][0][k] = min(tSum[i-1][0][k], tSum[i][0][k-1], Integer.MAX_VALUE) + arr[i][0][k];

        /* Initialize first width- First column of 
            tSum array */
        for (k = 1; k < n; k++)
            for (j = 1; j < m; j++)
                tSum[0][j][k] = min(tSum[0][j][k-1], tSum[0][j-1][k], Integer.MAX_VALUE) + arr[0][j][k];

        /* Construct rest of the tSum array */
        for (i = 1; i < l; i++)
            for (j = 1; j < m; j++)
                for (k = 1; k < n; k++)
                    tSum[i][j][k] = min(tSum[i-1][j][k], tSum[i][j-1][k], tSum[i][j][k-1]) + arr[i][j][k];

        return tSum[l-1][m-1][n-1];
    }
}
