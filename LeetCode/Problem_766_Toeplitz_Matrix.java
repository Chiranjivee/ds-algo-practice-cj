class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int topLeftI = i - 1;
                int topLeftJ = j - 1;
                if (topLeftI >= 0 && topLeftJ >= 0) {
                    if (matrix[i][j] != matrix[topLeftI][topLeftJ]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
