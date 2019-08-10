class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        Set<Integer> seen = new HashSet();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((k1, k2) ->
                grid[k1 / N][k1 % N] - grid[k2 / N][k2 % N]);
        pq.offer(0);
        int ans = 0;

        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        while (!pq.isEmpty()) {
            int k = pq.poll();
            int r = k / N, c = k % N;
            ans = Math.max(ans, grid[r][c]);
            if (r == N-1 && c == N-1) return ans;

            for (int i = 0; i < 4; ++i) {
                int cr = r + dr[i], cc = c + dc[i];
                int ck = cr * N + cc;
                if (0 <= cr && cr < N && 0 <= cc && cc < N && !seen.contains(ck)) {
                    pq.offer(ck);
                    seen.add(ck);
                }
            }
        }

        throw null;
    }
}
