class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0 || rectangles[0].length == 0) {
            return true;
        }
        Map<String, Set<Integer>> cnts = new HashMap<>();
        for (int[] rec : rectangles) {
            String[] ps = getPoints(rec);
            for (int i = 0; i < 4; ++i) {
                String p = ps[i];
                if (!cnts.containsKey(p)) {
                    cnts.put(p, new HashSet<>());
                }
                if (cnts.get(p).contains(i)) {
                    return false;
                }
                cnts.get(p).add(i);
            }
        }
        int corners = 0;
        for (String key : cnts.keySet()) {
            if (checkTwo(cnts.get(key)) || cnts.get(key).size() == 3 || cnts.get(key).size() > 4) {
                return false;
            }
            if (cnts.get(key).size() == 1) {
                ++corners;
            }
            if (corners > 4) {
                return false;
            }
        }
        return corners == 4;
    }
    
    private boolean checkTwo(Set<Integer> set) {
        if (set.size() != 2) {
            return false;
        }
        int sum = 0;
        for (int num : set) {
            sum += num;
        }
        return sum == 3;
    }
    
    private String[] getPoints(int[] rec) {
        Point[] p = new Point[4];
        for (int i = 0; i < 4; ++i) {
            p[i] = new Point(rec[i / 2 * 2], rec[1 + 2 * (i % 2)]);
        }
        Arrays.sort(p, new PointComparator());
        String[] res = new String[4];
        for (int i = 0; i < 4; ++i) {
            res[i] = p[i].x + "," + p[i].y;
        }
        return res;
    }
    
    private class PointComparator implements Comparator<Point> {
        public int compare(Point a, Point b) {
            if (a.x == b.x) {
                return a.y - b.y;
            } else {
                return a.x - b.x;
            }
        }
    }
    
    private class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
