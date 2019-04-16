class Solution {
    public int[][] generateMatrix(int n) {
        int [][] matrix = new int[n][n];
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        int v = 0;        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // go Right
            for (int j = colBegin; j <= colEnd; j++) {
                matrix[rowBegin][j] = ++v;
            }
            rowBegin++;
            
            // go down
            for (int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][colEnd] = ++v;
            }
            colEnd--;
            
            // go left
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    matrix[rowEnd][j] = ++v;
                }
                rowEnd--;
            }

            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    matrix[i][colBegin] = ++v;
                }    
                colBegin++;
            }
        }
        return matrix;
    }
}
