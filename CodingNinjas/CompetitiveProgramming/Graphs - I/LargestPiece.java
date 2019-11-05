public class LargestPiece {
    int[] xDir = { 1, 0, -1, 0 };
    int[] yDir = { 0, 1, 0, -1 };

    public int solve(int n, String cake[]) {
        // write your code here
        char[][] mat = new char[n][cake[0].length()];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < cake[0].length(); j++) {
                mat[i][j] = cake[i].charAt(j);
            }
        }

        int[][] visited = new int[n][cake[0].length()];

        int largestPiece = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < cake[0].length(); j++) {
                int res = dfs(mat, visited, i, j);
                largestPiece = Math.max(largestPiece, res);
            }
        }
        return largestPiece;
    }

    public int dfs(char[][] mat, int[][] visited, int startX, int startY) {
        visited[startX][startY] = 1;
        if (mat[startX][startY] == '0') {
            return 0;
        }

        int res = 1;
        for (int i = 0; i < 4; i++) {
            int nextX = startX + yDir[i];
            int nextY = startY + xDir[i];
            if (isValid(nextX, nextY, visited)) {
                res += dfs(mat, visited, nextX, nextY);
            }
        }

        return res;
    }

    boolean isValid(int x, int y, int[][] visited) {
        if (x < 0 || x >= visited.length || y < 0 || y >= visited[0].length || visited[x][y] == 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String[] s = new String[] { "110", "011", "000", "111", "111" };
        LargestPiece p = new LargestPiece();
        int ans = p.solve(5, s);
        System.out.println(ans);
    }
}
