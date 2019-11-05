class Solution {
    public int orangesRotting(int[][] grid) {

        // Initially, add all bad oranges to the queue
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    int[] pair = new int[2];
                    pair[0] = i;
                    pair[1] = j;
                    q.add(pair);
                }
            }
        }

        // Do BFS and each level of BFS is elapsed minute
        int level = 0;
        while (!q.isEmpty()) {
            // this size guarantess our level traversal
            int size = q.size();
            while (size > 0) {
                int[] pos = q.remove();
                // top
                if (pos[0] > 0) {
                    visitAndAdd(grid, pos[0] - 1, pos[1], q);
                }
                // right
                if (pos[1] < grid[0].length - 1) {
                    visitAndAdd(grid, pos[0], pos[1] + 1, q);
                }
                // bottom
                if (pos[0] < grid.length - 1) {
                    visitAndAdd(grid, pos[0] + 1, pos[1], q);
                }
                // left
                if (pos[1] > 0) {
                    visitAndAdd(grid, pos[0], pos[1] - 1, q);
                }
                size--;
            }

            // only count this as a level IF we converted any oranges to BAD
            if (!q.isEmpty())
                level++;
        }

        // one last check for any leftover fresh oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return level;
    }

    public void visitAndAdd(int[][] grid, int i, int j, Deque<int[]> q) {
        if (grid[i][j] == 1) {
            grid[i][j] = 2;
            int[] res = new int[2];
            res[0] = i;
            res[1] = j;
            q.add(res);
        }
    }
}
