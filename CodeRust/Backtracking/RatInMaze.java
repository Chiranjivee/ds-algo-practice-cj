
public class RatInMaze {
    public static void main(String[] args) {
        int [][] mat = new int[][] {{1, 1}, {1, 1}};
        ratInAMaze(mat);
    }

    public static void ratInAMaze(int matrix[][]) {

        int arr[][] = new int[matrix.length][matrix.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++)
                arr[i][j] = 0;
        }

        arr[0][0] = 1;
        ratInMaze(matrix, arr, 0, 0);
    }

    private static void ratInMaze(int[][] matrix, int[][] arr, int row, int col) {
        // if (row > matrix.length || col > matrix[0].length) return;
        // if (row < 0 || col < 0) return;
        if (row == arr.length - 1 && col == arr.length - 1) {
            // print
            
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++)
                    System.out.print(arr[i][j] + " ");
            }

            System.out.println();
            return;
        }

        // RightMovement
        if (col + 1 < arr[0].length) {
            if (matrix[row][col + 1] == 1 && arr[row][col + 1] != 1) {
                arr[row][col + 1] = 1;
                ratInMaze(matrix, arr, row, col + 1);
                arr[row][col + 1] = 0;
            }
        }

        // downMovement
        if (row + 1 < arr.length) {
            if (matrix[row + 1][col] == 1 && arr[row + 1][col] != 1) {
                arr[row + 1][col] = 1;
                ratInMaze(matrix, arr, row + 1, col);
                arr[row + 1][col] = 0;
            }
        }

        // upMovement
        if (row > 0) {
            if (matrix[row - 1][col] == 1 && arr[row - 1][col] != 1) {
                arr[row - 1][col] = 1;
                ratInMaze(matrix, arr, row - 1, col);
                arr[row - 1][col] = 0;
            }
        }

        // Left Movement
        if (col > 0) {
            if (matrix[row][col - 1] == 1 && arr[row][col - 1] != 1) {
                arr[row][col - 1] = 1;
                ratInMaze(matrix, arr, row, col - 1);
                arr[row][col - 1] = 0;
            }
        }

        return;
    }
}
