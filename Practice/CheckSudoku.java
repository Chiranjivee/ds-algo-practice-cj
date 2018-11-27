import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class CheckSudoku {
    public static boolean validateSudoku(int [][] sudoku) {
        Set<Integer> set = new HashSet<Integer>();

        int rowXor = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                set.add(sudoku[i][j]);
            }
            if (set.size() != 9) return false;
            set.clear();
        }

        int colXor = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                set.add(sudoku[j][i]);
            }
            if (set.size() != 9) return false;
            set.clear();
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                set = xorBlock(sudoku, i, j, set);
                if (set.size() != 9) return false;
                set.clear();
            }
        }
        return true;
    }

    public static Set<Integer> xorBlock(
        int [][] sudoku, 
        int startx, 
        int starty,
        Set<Integer> set) {
        int xor = 0;
        for (int i = startx; i < startx + 3; i++) {
            for (int j = starty; j < starty + 3; j++) {
                set.add(sudoku[i][j]);
            }
        }
        return set;
    }
    public static void main(String[] args) {
        int [][] sudoku = new int [][] {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {9, 1, 2, 3, 4, 5, 6, 7, 8},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4}
        };

        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(sudoku[i]));
        }
        System.out.println("Is sudoku valid ? " + FindXOR.validateSudoku(sudoku));
    }
}
