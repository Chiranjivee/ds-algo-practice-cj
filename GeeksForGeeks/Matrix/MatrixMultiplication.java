class MatrixMultiplication {
    public int[][] multiply(int [][] m1, int[][] m2) {
        int m = m1.length;
        int n = m1[0].length;
        int [][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    res[i][j] += m1[i][k] + m2[k][j];
                }
            }
        }

        return res;
    }

    public int[][] multiplyRectangular(int [][] m1, int[][] m2) {

        int rowM1 = m1.length;
        int colM1 = m1[0].length;

        int rowM2 = m2.length;
        int colM2 = m2[0].length;

        if (colM1 != rowM2) {
            return null;
        }

        int [][] res = new int[rowM1][colM2];
        for (int i = 0; i < rowM1; i++) {
            for (int j = 0; j < colM2; j++) {
                res[i][j] = 0;
                for (int k = 0; k < colM1; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        return res;
    }
}
