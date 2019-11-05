
public class Solution {

	static int[] xdir = { 1, 0, -1, 0 };
	static int[] ydir = { 0, -1, 0, 1 };

	public static void ratInAMaze(int maze[][]) {
		int size = maze[0].length;
		int[][] sol = new int[size][size];

		sol[0][0] = 1;
		ratInAMazeUtil(maze, sol, 0, 0);
	}

	public static void ratInAMazeUtil(int[][] maze, int[][] sol, int x, int y) {
		if (x == maze.length - 1 && y == maze.length - 1) {
			printSolution(sol);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextX = x + xdir[i];
			int nextY = y + ydir[i];
			if (isSafe(maze, sol, nextX, nextY)) {
				sol[nextX][nextY] = 1;
				ratInAMazeUtil(maze, sol, nextX, nextY);
				sol[nextX][nextY] = 0;
			}
		}
	}

	public static void printSolution(int[][] sol) {
		for (int i = 0; i < sol[0].length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j] + " ");
			}
		}
		System.out.println();
	}

	public static boolean isSafe(int[][] maze, int[][] sol, int nextX, int nextY) {
		if (!(nextX >= 0 && nextX < maze[0].length) || !(nextY >= 0 && nextY < maze[0].length) || maze[nextX][nextY] == 0) {
			return false;
		}

		if (sol[nextX][nextY] == 1)
			return false;

		return true;
	}
}
