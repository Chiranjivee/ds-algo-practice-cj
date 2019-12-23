class FindEndlessPoints {
    public int getEndlessPoints(int [][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int [][] one = new int[row][col];
        int [][] two = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = col - 1; j >= 0; j--) {

                if (mat[i][j] == 0) {
                    one[i][j] = 0;
                    continue;
                }

                if (j == col - 1) {
                    one[i][j] = mat[i][j];
                }

                one[i][j] = one[i][j + 1];
            }
        }

        for (int i = 0; i < col; j++) {
            for (int j = row - 1; j >= 0; j--) {

                if (mat[i][j] == 0) {
                    two[i][j] = 0;
                    continue;
                }

                if (j == row - 1) {
                    two[i][j] = mat[i][j];
                }

                two[i][j] = one[j + 1][i];
            }
        }

        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (one[i][j] == 1 && two[i][j] == 1) {
                    res++;
                }
            }
        }

        return res;
    }
}
