class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> pq = new PriorityQueue<>(K + 1, (a,b) -> b.dist - a.dist);
        for (int[] point : points) {
            Point p = new Point();
            p.xy = point;
            p.dist = getDist(p);
            pq.add(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        
        int [][] res = new int[pq.size()][2];
        int i = 0;
        for (Point p : pq) {
            res[i++] = p.xy;
        }
        return res;
    }
    
    public int getDist(Point p) {
        return p.xy[0] * p.xy[0] + p.xy[1] * p.xy[1];
    }
    
    
}

class Point {
    int [] xy;
    int dist;
}
