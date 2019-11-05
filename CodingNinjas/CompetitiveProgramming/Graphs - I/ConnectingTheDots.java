
public class ConnectingTheDots {

    int[] xDir = { 1, 0, -1, 0 };
    int[] yDir = { 0, 1, 0, -1 };

    int solve(String[] board, int n, int m) {
        // Write your code here.
        char[][] graph = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                graph[i][j] = board[i].charAt(j);
            }
        }

        NodeStatus[][] visited = new NodeStatus[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                visited[i][j] = NodeStatus.UNVISITED;
            }
        }

        int[] count = new int[1];

        for (char c = 'A'; c <= 'Z'; c++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] == c && visited[i][j] == NodeStatus.UNVISITED)
                        dfsUtil(graph, visited, i, j, count, c);
                    if (count[0] > 4) {
                        return 1;
                    }

                    count[0] = 0;
                }
            }
        }

        return 0;
    }

    public void dfsUtil(char[][] graph, NodeStatus[][] visited, int startX, int startY, int[] count, char currentChar) {
        System.out.println("StartX: " + startX + ", startY: " + startY);
        visited[startX][startY] = NodeStatus.IS_BEING_VISITED;
        count[0]++;
        for (int i = 0; i < 4; i++) {
            int nextX = startX + xDir[i];
            int nextY = startY + yDir[i];

            if (isValid(nextX, nextY, visited, graph, currentChar)) {
                dfsUtil(graph, visited, nextX, nextY, count, currentChar);
                if (visited[nextX][nextY] == NodeStatus.IS_BEING_VISITED && count[0] > 4) {
                    break;
                }
            }
        }

        visited[startX][startY] = NodeStatus.VISITED;
    }

    public boolean isValid(int x, int y, NodeStatus[][] visited, char[][] graph, char currentChar) {
        if (x < 0 || x >= visited.length || y < 0 || y >= visited[0].length || visited[x][y] == NodeStatus.VISITED
                || currentChar != graph[x][y] || visited[x][y] == NodeStatus.IS_BEING_VISITED) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] board = new String[] { "AAAA", "ABCA", "AAAA" };

        ConnectingTheDots dots = new ConnectingTheDots();
        int result = dots.solve(board, 3, 4);
        System.out.println(result);
    }
}

enum NodeStatus {
    VISITED, UNVISITED, IS_BEING_VISITED
}