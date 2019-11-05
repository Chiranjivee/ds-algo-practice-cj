class Solution {
    private class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int segmentLength(Point other) {
            return other.x == this.x ? Math.abs(other.y - this.y) :
                                       Math.abs(other.x - this.x);
        }
        private Point copyAndAdjustPoint(int i, int amount) {
            Point copy = new Point(this.x, this.y);
            switch(i % 4) {
                case 0:
                    copy.y += amount;
                    break;
                case 1:
                    copy.x -= amount;
                    break;
                case 2:
                    copy.y -= amount;
                    break;
                case 3:
                    copy.x += amount;
                    break;
            }
            return copy;
        }
    }

    public boolean isSelfCrossing(int[] x) {
        LinkedList<Point> points = new LinkedList<Point>();
        int state = 0;
        Point curPoint = new Point(0,0);
        points.add(curPoint);
        
        for(int i = 0; i < x.length; i++) {
            curPoint = curPoint.copyAndAdjustPoint(i, x[i]);
            points.add(curPoint);
            switch(state) {
                case 0:
                    state = 1;
                    break;
                case 1:
                    state = 2;
                    break;
                case 2:
                    if(points.get(3).segmentLength(points.get(2)) > points.get(1).segmentLength(points.get(0))) {
                        state = 4;
                    } else {
                        state = 3;
                    }
                    break;
                case 3:
                    if(points.get(4).segmentLength(points.get(3)) >= points.get(2).segmentLength(points.get(1))) {
                        return true;
                    } else {
                        points.removeFirst();
                        state = 3;
                    }
                    break;
                case 4:
                    if(points.get(4).segmentLength(points.get(3)) < points.get(2).segmentLength(points.get(1))) {
                        points.removeFirst();
                        state = 3;
                    } else {
                        state = 5;
                    }
                    break;
                case 5:
                    int l1 = points.get(5).segmentLength(points.get(4));
                    int l2 = points.get(3).segmentLength(points.get(2));
                    int l3 = points.get(1).segmentLength(points.get(0));
                    if(l1 + l3 < l2) {
                        points.removeFirst();
                        points.removeFirst();
                        state = 3;
                    } else if(l1 + l3 > l2) {
                        if(l1 > l2) {
                            points.removeFirst();
                        } else {
                            state = 6;
                        }
                    }
                    break;
                case 6:
                    l1 = points.get(6).segmentLength(points.get(5));
                    l2 = points.get(4).segmentLength(points.get(3));
                    l3 = points.get(2).segmentLength(points.get(1));
                    if(l1 + l3 >= l2) {
                        return true;
                    } else {
                        points.removeFirst();
                        points.removeFirst();
                        points.removeFirst();
                        state = 3;
                    }
                    break;
            }
            Point start = points.peekFirst();
            Point end = points.peekLast();
            if(start.x == end.x && start.y == end.y) return true;
        }
        return false;
    }
}
