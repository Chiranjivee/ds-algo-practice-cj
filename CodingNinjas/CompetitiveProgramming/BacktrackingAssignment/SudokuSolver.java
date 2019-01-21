public class SudokuSolver {
    public static boolean sudokuSolver(int board[][]) {
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    // try filling the current block 
                    for (int num = 1; num <= 9; num++) {
                        if (isNumSafe(board, i, j, num)) {
                            board[i][j] = num;
                            if (sudokuSolver(board)) {
                                return true;
                            } else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
		
        return true;
    }

    public static boolean isNumSafe(int [][] board, int i, int j, int num) {
        // check in ith row
        for (int a = 0; a < 9; a++) {
            if (board[i][a] == num && a != j) {
                return false;
            }
        }
        for (int a = 0; a < 9; a++) {
            if (board[a][j] == num && a != i) {
                return false;
            }
        }

        int boxI = i / 3;
        int boxJ = j / 3;
        int boxIStart = boxI * 3;
        int boxJStart = boxJ * 3;
        for (int a = boxIStart; a < boxIStart + 3; a++) {
            for (int b = boxJStart; b < boxJStart + 3; b++) {
                if (board[a][b] == num && a != i && b != j) {
                    return false;
                }
            }
        }

        return true;
    }
}
