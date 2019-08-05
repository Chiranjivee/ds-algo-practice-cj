import java.awt.Point;
public class Solution {
    public int orientation(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }
    public boolean inBetween(Point p, Point i, Point q) {
        boolean a = i.x >= p.x && i.x <= q.x || i.x <= p.x && i.x >= q.x;
        boolean b = i.y >= p.y && i.y <= q.y || i.y <= p.y && i.y >= q.y;
        return a && b;
    }
    public int[][] outerTrees(int[][] points) {
        Point[] pnts = new Point[points.length];
        for (int i = 0; i < points.length; ++i) {
            pnts[i] = new Point(points[i][0], points[i][1]);
        }
        
        List<Point> res = outerTrees(pnts);
        int [][] resArr = new int[res.size()][2];
        int i = 0;
        for (int [] temp : resArr) {
            temp[0] = res.get(i).x;
            temp[1] = res.get(i).y;
            i++;
        }
        return resArr;
    }
    
    public List < Point > outerTrees(Point[] points) {
        HashSet < Point > hull = new HashSet < > ();
        if (points.length < 4) {
            for (Point p: points)
                hull.add(p);
            return new ArrayList<Point>(hull);
        }
        int left_most = 0;
        for (int i = 0; i < points.length; i++)
            if (points[i].x < points[left_most].x)
                left_most = i;
        int p = left_most;
        do {
            int q = (p + 1) % points.length;
            for (int i = 0; i < points.length; i++) {
                if (orientation(points[p], points[i], points[q]) < 0) {
                    q = i;
                }
            }
            for (int i = 0; i < points.length; i++) {
                if (i != p && i != q && orientation(points[p], points[i], points[q]) == 0 && inBetween(points[p], points[i], points[q])) {
                    hull.add(points[i]);
                }
            }
            hull.add(points[q]);
            p = q;
        }
        while (p != left_most);
        return new ArrayList<Point>(hull);
    }
}
