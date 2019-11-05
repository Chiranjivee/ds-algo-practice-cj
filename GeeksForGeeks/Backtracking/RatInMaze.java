class RatInMaze {
    int [][] maze;
    int mazeSize;
    int [][] solution;

    public RatInMaze(int[][] maze, int size) {
        this.maze = maze;
        this.solution = new int[size][size];
        this.mazeSize = size;
    }

    public boolean isSafe(int x, int y, int[][] maze) {
        if (x >= 0 && x < mazeSize 
            && y >= 0 && y < mazeSize &&
            maze[x][y] == 1) {
                return true;
        }
        return false;
    }

    public void printSol() {
        for (int i = 0; i < mazeSize; i++) {
            for (int j = 0; j < mazeSize; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }


    public void solve() {
        if (solveUtil(0, 0, maze, solution)) {
            printSol();
        } else {
            System.out.println("No solution exists");
        }
    }

    public boolean solveUtil(int x, int y, int [][] maze, int [][] sol) {
        if (x == mazeSize - 1 && y == mazeSize - 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(x, y, maze)) {
            sol[x][y] = 1;
            if (solveUtil(x + 1, y, maze, sol)) return true;
            if (solveUtil(x, y + 1, maze, sol)) return true;
            sol[x][y] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        
        int maze[][] = 
            {{1, 0, 0, 0}, 
            {1, 1, 0, 1}, 
            {0, 1, 0, 0}, 
            {1, 1, 1, 1}};
        RatInMaze ratInMaze = new RatInMaze(maze, 4);
        ratInMaze.solve();
    }
}