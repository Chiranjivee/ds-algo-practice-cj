class Solution {
    private static void printMatrix(int mat[][], int m, int n, int i, int j, int path[], int idx) {
        path[idx] = mat[i][j];

        // Reached the bottom of the matrix so we are left with 
        // only option to move right 
        if (i == m - 1) {
            for (int k = j + 1; k<n; k++) {
                path[idx + k - j] = mat[i][k];
            }
            for (int l = 0; l<idx + n - j; l++) {
                System.out.print(path[l] + " ");
            }
            System.out.println();
            return;
        }

        // Reached the right corner of the matrix we are left with 
        // only the downward movement. 
        if (j == n - 1) {
            for (int k = i + 1; k<m; k++) {
                path[idx + k - i] = mat[k][j];
            }
            for (int l = 0; l<idx + m - i; l++) {
                System.out.print(path[l] + " ");
            }
            System.out.println();
            return;
        }
        // Print all the paths that are possible after moving down 
        printMatrix(mat, m, n, i + 1, j, path, idx + 1);

        // Print all the paths that are possible after moving right 
        printMatrix(mat, m, n, i, j + 1, path, idx + 1);
    }
}
