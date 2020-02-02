class CheckIntersection {
    public boolean isIntersect(Line l1, Line l2) {
        int m1 = l1.getSlope();
        int m2 = l2.getSlope();

        if (m1 == m2) {
            return false;
        }

        return true;
    }
}

class Line {
    Point x;
    Point y;

    double slope;

    public double getSlope() {
        int X2_X1 = y.x - x.x;
        int Y2_Y1 = y.y - x.y;

        if (X2_X1 == 0) return Double.MAX_VALUE;

        return  Y2_Y1 / X2_X1;
    }
}

class Point {
    int x;
    int y;
}
