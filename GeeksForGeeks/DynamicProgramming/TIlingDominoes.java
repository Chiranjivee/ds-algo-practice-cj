/**
 * 
 * Tiling Dominoes: 
 * Tile a board with 3 x n size with a tile of 2 x 1 size.
 * 
 * A(n) = 3 * A(n - 2) + 2 * B (n - 1)
 * 
 * B(n) = A(n - 1) + B(n - 2)
 * 
 */
class TilingDominoes {

    public int numberOfWaysToTileBoardA(int n) {
        if (n < 0) {
            return 0; 
        }

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 0;
        }

        return 3 * numberOfWaysToTileBoard(n - 2) + 2 * numberOfWaysToTileBoardB(n - 1);
    }

    public int numberOfWaysToTileBoardB(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return numberOfWaysToTileBoardA(n - 1) + numberOfWaysToTileBoardB(n - 2);
    }

    public int numberOfWaysToTileBoardBottomUP(int n) {
        int [] A = new int[n + 1];
        int [] B = new int[n + 1];

        A[0] = 1;
        A[1] = 0;

        B[0] = 0;
        B[1] = 1;

        for (int i = 2; i <= n; i++) {
            A[i] = 3 * A[i - 2] + 2 * B[i - 1];
            B[i] = A[i - 1] + B[i - 2];
        }
        
        return A[n];
    }
}
