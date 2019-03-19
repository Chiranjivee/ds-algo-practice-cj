import java.util.*;

public class ConnectedHorses {
    static int MOD = 1_000_000_007;
    static int [] yDir = {2, 2, -2, -2, 1, -1, 1, -1};
    static int [] xDir = {1, -1, 1, -1, 2, 2, -2, -2};
	
	public static void main(String[] args) {
		// Write your code here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            Horse [][] board = new Horse[n][m];
            int q = sc.nextInt();
            
            for (int i = 0; i < q; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                board[x - 1][y - 1] = new Horse(x - 1, y - 1, i);
            }
            
            ArrayList<Integer>[] graph = new ArrayList[q];
            for (int i = 0; i < q; i++) {
                graph[i] = new ArrayList<>();
            }
            sc.close();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] != null) {
                        Horse current = board[i][j];
                        for (int d = 0; d < 8; d++) {
                            int nextX = current.x + xDir[d];
                            int nextY = current.y + yDir[d];
                            if (isValid(nextX, nextY, board)) {
                                graph[current.id].add(board[nextX][nextY].id);
                            }
                        }
                    }
                }
            }

            boolean [] visited = new boolean[q];
            List<List<Integer>> components = new ArrayList<>();
            for (int i = 0; i < q; i++) {
                dfs(i, visited, components, graph);
            }
            
            long result = 1;
            for (List<Integer> component : components) {
                result = ((result % MOD) * (fact(component.size()) % MOD) % MOD);
            }
            
            System.out.println(result % MOD);
        }
	}
    
    public static long fact(int n) {
        long res = 1;
        while (n > 1) {
            res = ((res % MOD) * (n % MOD)) % MOD;
            n--;
        }
        return res;
    }
    
    public static boolean isValid(int x, int y, Horse[][] board) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == null) {
            return false;
        }

        return true;
    }
    
    public static void dfs(int s, boolean[] visited, List<List<Integer>> components, ArrayList<Integer>[] graph) {
        if (visited[s]) return;
        
        List<Integer> path = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        visited[s] = true;
        stack.push(s);
        while (stack.size() != 0) {
            s = stack.pop();
            path.add(s);
            for (int i = 0; i < graph[s].size(); i++) {
                int neighbour = graph[s].get(i);
                if (neighbour == s) continue;
                
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    stack.push(neighbour);
                }   
            }
        }
        
        components.add(path);
    }
}

class Horse {
    int x;
    int y; 
    int id;
    
    public Horse(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
}