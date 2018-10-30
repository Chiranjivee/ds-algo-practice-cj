
/**
* The problem is to find a solution so that a knigh on a chess board 
* starting from the location 0,0 can it cover all the other 64 blocks exactly once.
*/
class KnightsTour {
    int boardSize = 8;

    int [] movesX = {2, 1, -1, -2, -2, -1, 1, 2};
    int [] movesY = {1, 2, 2, 1, -1, -2, -2, -1};

    int [][] sol;

    KnightsTour() {
        this.sol = new int[8][8];
    }

    void printSolution() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    void doTour() {
        initSolnMatrix();
        sol[0][0] = 0;

        if (!doTourUtil(0, 0, movesX, movesY, sol, 1)) {
            System.out.println("No solution exists");
        } else {
            printSolution();
        }
    }

    boolean doTourUtil(int x, int y, int [] movesX, int[] movesY, int [][] sol, int moveNum) {
        
        if (moveNum == boardSize * boardSize) {
            return true;
        }

        for (int k = 0; k < 8; k++) {
            int nextX = x + movesX[k];
            int nextY = y + movesY[k];

            if (isSafeMethod(nextX, nextY, sol)) {
                sol[nextX][nextY] = moveNum;
                if (doTourUtil(nextX, nextY, movesX, movesY, sol, moveNum + 1)) {
                    return true;
                } else {
                    sol[nextX][nextY] = -1;
                }
            }
        }

        return false;
    }

    void initSolnMatrix() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                sol[i][j] = -1;
            }
        }
    }

    boolean isSafeMethod(int x, int y, int[][] sol) {
        if (x >= 0 && x < 8 &&
            y >= 0 && y < 8 && 
            sol[x][y] == -1) {
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        KnightsTour tour = new KnightsTour();
        tour.doTour();
    }
}