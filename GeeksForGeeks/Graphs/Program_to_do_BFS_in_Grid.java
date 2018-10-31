import java.util.LinkedList;
import java.util.Queue;

class GridNode {
	int x;
	int y;
	int data;
	public GridNode(int x, int y, int data) {
		this.x = x;
		this.y = y;
		this.data = data;
	}
}

class Graph {

	int [] xMoves = {1, 0, -1, 0};
	int [] yMoves = {0, 1, 0, -1};

	public void bfs(int [][] matrix, boolean[][] isVisited) {
        GridNode startNode = new GridNode(0, 0, matrix[0][0]);
        isVisited[0][0] = true;
		Queue<GridNode> queue = new LinkedList<>();
		queue.offer(startNode);

		while (!queue.isEmpty()) {
			GridNode node = queue.remove();
			System.out.print(node.data + " => ");
			
			for (int i = 0; i < 4; i++) {
				int nextX = node.x + xMoves[i];
				int nextY = node.y + yMoves[i];
				if (isSafe(nextX, nextY, matrix[0].length, matrix.length, isVisited)) {
                    isVisited[nextX][nextY] = true;
					queue.offer(new GridNode(nextX, nextY, matrix[nextX][nextY]));
				}
			}
		}
	}

	public boolean isSafe(int x, int y, int rows, int cols, boolean [][] isVisited) {
		if (x >= 0 && x < rows && y >= 0 && y < cols && isVisited[x][y] == false) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Graph graph = new Graph();

		int [][] myGrid = {
			{ 1, 2, 3, 4 },
			{ 5, 6, 7, 8 },
			{9, 10, 11, 12},
			{13, 14, 15, 16}
		};

		boolean [][] isVisited = new boolean[4][4];
        graph.bfs(myGrid, isVisited);
    }
}