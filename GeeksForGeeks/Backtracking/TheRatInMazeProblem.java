class RatInMaze {
    boolean solveMaze(int maze[][]) {
        int sol[][] = new int[N][N];
    
        if (solveMazeUtil(maze, 0, 0, sol) == false) {
            System.out.print("Solution doesn't exist");
            return false;
        }
    
        printSolution(sol);
        return true;
    }
    
    /* A recursive utility function to solve Maze  
    problem */
    boolean solveMazeUtil(int maze[][], int x, int y,
        int sol[][]) {
        // if (x, y is goal) return true 
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }
    
        // Check if maze[x][y] is valid 
        if (isSafe(maze, x, y) == true) {
            // mark x, y as part of solution path 
            sol[x][y] = 1;
    
            /* Move forward in x direction */
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;
    
            /* If moving in x direction doesn't give  
            solution then Move down in y direction */
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;
    
            /* If none of the above movements works then  
            BACKTRACK: unmark x, y as part of solution  
            path */
            sol[x][y] = 0;
            return false;
        }
    
        return false;
    }
}
