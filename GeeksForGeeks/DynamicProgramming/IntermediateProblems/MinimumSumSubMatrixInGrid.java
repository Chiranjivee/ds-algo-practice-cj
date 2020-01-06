class MinimumSumSubMatrixInGrid {
    public int minSumSubMatrix(int [][] grid, int row, int col) {
        int minSum = Integer.MAX_VALUE;
        int finalLeft = 0;
        int finalRight = 0;
        int finalTop = 0;
        int finalBottom = 0;

        int left, right, i;

        for (int left = 0; left < col; left++) {
            int [] temp = new int[row];
            for (int right = left; right < col; right++) {
                for (int i = 0; i < row; i++) {
                    temp[i] += grid[i][right];
                }

                // res[0] = kadane sum, res[1] = start idx, res[2] = end idx
                res = kadane(temp);
                if (sum < minSum) {
                    minSum = sum;
                    finalLeft = left;
                    finalRight = right;
                    finalTop = res[1];
                    finalBottom = res[2];
                }
            }
        }

        printSol(finalLeft, finalRight, finalTop, finalBottom, minSum);
    }
}
