class Solution {
    public int trapRainWater(int[][] heightMap) {
        int nrow = heightMap.length;
        if (heightMap.length == 0) {
            return 0;
        }
        int ncol = heightMap[0].length;
        if (nrow < 3 || ncol < 3) {
            return 0;
        }
        Queue<Point> heap = new PriorityQueue<>();
        boolean[][] visited = new boolean[nrow][ncol];
		// push all border points to the heap. they are where we start our search.
        initialization(heightMap, heap, visited, nrow, ncol);
        int result = 0;
        while (!heap.isEmpty()) {
			// poll out the point where we have the smallest height. like a bucket with shorted side.
            Point curr = heap.poll();
			// generate neighbors of current point.
            List<Point> neis = getNeis(curr, heightMap, visited, nrow, ncol);
            for (Point nei : neis) {
				// if current point can hold water, add it to final result
                result += Math.max(0, curr.h - nei.h);
				// set value for propagation
                nei.h = Math.max(curr.h, nei.h);
                heap.offer(nei);
            }
        }
        return result;
    }
    
    private void initialization(int[][] map, Queue<Point> heap, boolean[][] visited, int nrow, int ncol) {
        for (int i = 0; i < nrow; i++) {
            heap.offer(new Point(i, 0, map[i][0]));
            heap.offer(new Point(i, ncol - 1, map[i][ncol - 1]));
            visited[i][0] = true;
            visited[i][ncol - 1] = true;
        }
        for (int i = 1; i < ncol - 1; i++) {
            heap.offer(new Point(0, i, map[0][i]));
            heap.offer(new Point(nrow - 1, i, map[nrow - 1][i]));
            visited[0][i] = true;
            visited[nrow - 1][i] = true;
        }
    }
    
    private List<Point> getNeis(Point curr, int[][] map, boolean[][] visited, int nrow, int ncol) {
        List<Point> result = new ArrayList<>();
        if (curr.r + 1 < nrow && !visited[curr.r + 1][curr.c]) {
            result.add(new Point(curr.r + 1, curr.c, map[curr.r + 1][curr.c]));
            visited[curr.r + 1][curr.c] = true;
        }
        if (curr.r - 1 >= 0 && !visited[curr.r - 1][curr.c]) {
            result.add(new Point(curr.r - 1, curr.c, map[curr.r - 1][curr.c]));
            visited[curr.r - 1][curr.c] = true;
        }
        if (curr.c + 1 < ncol && !visited[curr.r][curr.c + 1]) {
            result.add(new Point(curr.r, curr.c + 1, map[curr.r][curr.c + 1]));
            visited[curr.r][curr.c + 1] = true;
        }
        if (curr.c - 1 >= 0 && !visited[curr.r][curr.c - 1]) {
            result.add(new Point(curr.r, curr.c - 1, map[curr.r][curr.c - 1]));
            visited[curr.r][curr.c - 1] = true;
        }
        return result;
    }
    
    static class Point implements Comparable<Point>{
        int r;
        int c;
        int h;
        public Point(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
        @Override
        public int compareTo(Point o) {
            return Integer.compare(h, o.h);
        }
    }
}
