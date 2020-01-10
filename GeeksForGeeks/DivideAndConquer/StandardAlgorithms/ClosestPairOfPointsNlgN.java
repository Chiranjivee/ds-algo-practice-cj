class ClosestPairOfPoints {
    public int getClosestPair(Point [] points) {
        Arrays.sort(points, (a, b) -> a.x - b.x);
        Arrays.sort(points, (a, b) -> a.y - b.y);
        int start = 0;
        int end = points.length - 1;
        getClosestPairDivide(points, start, end);        
    }

    public int getClosestPairDivide(Point [] points, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = (start + end) / 2;

        int left = getClosestPairDivide(points, start, mid);
        int right = getClosestPairDivide(points, mid + 1, end);

        int d = Math.min(left, right);

        // make a strip of points where points are in range +-d from middle line;
        List<Point> strip = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (Math.abs(points[i].x - points[mid].x) < d) {
                strip.add(points[i]);
            }
        }

        Point[] stripArray = strip.toArray(new Point[strip.size()]);
        return getClosestPairConquer(strip, d);
    }

    public int getClosestPairConquer(Points[] strip, int d) {
        // this loop alwasy runs 6 times
        for (int i = 0; i < strip.length - 1; i++) {
            for (int j = i + 1; j < strip.length; j++) {
                d = Math.min(d, Math.abs(strip[i].y - strip[j].y));
            }
        }

        return d;
    }
}

class Point {
    int x;
    int y;
}
