
public class CodingNinja {
    int [] xDir = {1, 1, 0, -1, -1, -1, 0, 1};
    int [] yDir = {0, 1, 1, 1, 0, -1, -1, -1};
	
	int solve(String[] Graph , int N, int M)
	{
		// Write your code here.
        char [][] mat = new char[N][M];
        for (int i = 0; i < Graph.length; i++) {
            String curr = Graph[i];
            for (int j = 0; j < curr.length(); j++) {
                mat[i][j] = curr.charAt(j);
            }
        }
        
        int [][] visited = new int[N][M];
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (visited[i][j] == 1) {
                    continue;
                } else {
                    if (mat[i][j] == 'C') {
                        int ans = solveUtil(mat, visited, i, j, new StringBuilder());
                        if (ans == 1) {
                            return 1;
                        }
                    }
                }
            }
        }

        return 0;
	}	
    
    int solveUtil(char [][] mat, int [][] visited, int startX, int startY, StringBuilder builder) {
        builder.append(mat[startX][startY]);
        visited[startX][startY] = 1;
        if (!builder.toString().equals("") && !"CODINGNINJA".startsWith(builder.toString())) {
            return 0;
        }
        
        
        if (builder.toString().equals("CODINGNINJA")) {
            return 1;
        }

        for (int i = 0; i < 8; i++) {
             int nextX = startX + yDir[i];
             int nextY = startY + xDir[i];
             if (isValid(nextX, nextY, visited)) {
                int res = solveUtil(mat, visited, nextX, nextY, builder);            
                if (res == 0) {
                    builder.setLength(builder.length() - 1);
                    visited[nextX][nextY] = 0;
                } 
                if (res == 1) {
                    return 1;
                }
            }
        }
        
        return 0;
    }
    
    
    boolean isValid(int x, int y, int[][] visited) {
        if (x < 0 || x >= visited.length || y < 0 || y >= visited[0].length || visited[x][y] == 1) {
            return false;
        } return true;
    }

    public static void main(String[] args) {
        CodingNinja ninja = new CodingNinja();
        String[] s = new String[] {"CANI", "OOJN", "DDIG", "JNIN"};
        System.out.println(ninja.solve(s, 4, 4));
    }
}

