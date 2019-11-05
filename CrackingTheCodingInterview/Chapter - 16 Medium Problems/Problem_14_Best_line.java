import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

class BestLine {
    Line findBestLine(GraphPoint[] points) {
        HashMap<Double, List<Line>> linesBySlope = getListOfLines(points);
        return getBestLine(linesBySlope);
    }

    HashMap<Double, List<Line>> getListOfLines(GraphPoint[] points) {
        HashMap<Double, List<Line>> linesBySlope = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line line = new Line(points[i], points[j]);
                double key = Line.floorToNearestEpsilon(line.slope);
                if (!linesBySlope.containsKey(key)) {
                    linesBySlope.put(key, new ArrayList<>());
                }
                linesBySlope.get(key).add(line);
            }
        }
        return linesBySlope;
    }

    int countParallelLine(List<Line> lines, Line line) {
        int count = 0;
        if (lines == null) return count;
        for (Line parallelLine : lines) {
            if (parallelLine.equals(line)) {
                count++;
            }
        }
        return count;
    }

    public int countEquivalentLines(HashMap<Double, List<Line>> lines, Line line) {
        int count = 0;
        double key = Line.floorToNearestEpsilon(line.slope);
        count += countParallelLine(lines.get(key), line);
        count += countParallelLine(lines.get(key - Line.epsilon), line);
        count += countParallelLine(lines.get(key + Line.epsilon), line);
        return count;
    }

    Line getBestLine(HashMap<Double, List<Line>> linesBySlope) {
        Line bestLine = null;
        int bestCount = 0;

        Set<Double> slopes = linesBySlope.keySet();
        for (Double slope : slopes) {
            List<Line> lines = linesBySlope.get(slope);
            for (Line line: lines) {
                int count = countEquivalentLines(linesBySlope, line);

                if (count > bestCount) {
                    bestLine = line;
                    bestCount = count;
                }
            }
        }
        return bestLine;
    }
}

class Line {
    public static double epsilon = 0.001;
    public double slope;
    public double intercept;
    public boolean infiniteSlope = false;

    public Line(GraphPoint p, GraphPoint q) {
        // if x co-ordinate are different
        if (Math.abs(p.x - q.x) > epsilon) {
            slope = (q.y - p.y) / (p.x - q.x);
            intercept = p.y - slope * p.x;
        } else {
            infiniteSlope = true;
            intercept = p.x;
        }
    }
    public boolean isEquivalent(double a, double b) {
        return Math.abs(a - b) < epsilon;
    }
    
    public static double floorToNearestEpsilon(double d) {
        int x = (int) (d / epsilon);
        return ((double) x) * epsilon;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Line temp = (Line) o;
        if (isEquivalent(temp.slope, slope)
            && infiniteSlope == temp.infiniteSlope &&
            isEquivalent(temp.intercept, intercept)) {
                return true;
            }
        return false;
    }
}

class GraphPoint {
    int x;
    int y;
    public GraphPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
