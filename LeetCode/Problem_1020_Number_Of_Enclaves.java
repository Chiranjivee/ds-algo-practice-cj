class Solution {
    public int numEnclaves(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (i == 0 || i == A.length - 1 || j == 0 || j == A[0].length - 1 && A[i][j] == 1) {
                    dfs(i, j, A);
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    res++;
                }
            }
        }

        return res;
    }
    
    public void dfs(int i, int j, int [][] grid) {
        if (i < 0 || i >= grid.length) return;
        if (j < 0 || j >= grid[0].length) return;
        if (grid[i][j] == 0) return;
        
        grid[i][j] = 0;
        dfs(i, j + 1, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i - 1, j, grid);
    }
}
