import java.util.List;
import java.util.ArrayList;

class DFSBacktrack {
    int [] xMoves = { 1, 1, 0, -1, -1, -1, 0, 1};
    int [] yMoves = { 0, 1, 1, -1, 0, -1, -1, -1};

    public void dfs(int [][] graph) {
        boolean [][] visited = new boolean [3][3];
        dfsUtil(graph, visited, new Point(0,0), new ArrayList<>());;
    }

    public void dfsUtil(
        int[][] graph, boolean [][] visited,
        Point start,
        List<Integer> path) {

        visited[start.x][start.y] = true;
        path.add(graph[start.x][start.y]);
        for (int i = 0; i < 8; i++) {
            int nextX = start.x + xMoves[i];
            int nextY = start.y + yMoves[i];
            if (isValid(nextX, nextY, graph) && !visited[nextX][nextY]) {
                
                dfsUtil(
                    graph, 
                    visited, 
                    new Point(nextX, nextY), 
                    path);
                visited[nextX][nextY] = false;
                path.remove(path.size() - 1);
            }
        }
        System.out.println(path);
    }
    public boolean isValid(int x, int y, int [][] graph) {
        // System.out.println("X is : " + x + " Y is: " + y);
        if (x < 0 || x >= graph.length || y < 0 || y >= graph.length) {
            return false;
        }
        // System.out.println("X is : " + x + " Y is: " + y);
        return true;
    }
    
    public static void main(String[] args) {
        int [][] graph = new int [][] {
                    {1, 2}, 
                    {3, 4}};
        DFSBacktrack bt = new DFSBacktrack();
        bt.dfs(graph);
    }
}

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
