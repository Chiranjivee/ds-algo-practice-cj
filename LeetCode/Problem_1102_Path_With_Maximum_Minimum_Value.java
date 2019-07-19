class Solution {
    int[] dx = new int[]{-1, 0, 0, 1};
    int[] dy = new int[]{0, -1, 1, 0};
    
    int M, N;

    public int maximumMinimumPath(int[][] A) {
        M = A.length;
        N = A[0].length;
        
        int lo = 0, hi = 1000000000;
        
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (!check(A, mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        
        if (check(A, lo)) {
            return lo;
        }
        
        return hi;
    }
    
    private boolean check(int[][] A, int limit) {
        if (A[0][0] < limit) {
            return false;
        }

        boolean[][] visited = new boolean[M][N];
        Queue<int[]> q = new LinkedList<>();
        
        visited[0][0] = true;
        q.offer(new int[]{0, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();              
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i], ny = cur[1] + dy[i];

                if (inBound(nx, ny) && !visited[nx][ny] && A[nx][ny] >= limit) {
                    if (nx == M - 1 && ny == N - 1) {
                        return true;
                    }
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        return visited[M - 1][N - 1];
    }
    
    private boolean inBound(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}
