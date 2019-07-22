class Solution {
    class Interval {
        int start;
        int end;
        public Interval (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Interval[] interval = new Interval[intervals.length];
        int i = 0;
        for (int [] inter: intervals) {
            interval[i++] = new Interval(inter[0], inter[1]);
        }
        return eraseOverlapIntervals(interval);
    }
    
    class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
    
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new myComparator());
        int end = intervals[0].end, prev = 0, count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prev].end > intervals[i].start) {
                if (intervals[prev].end > intervals[i].end) {
                    prev = i;
                }
                count++;
            } else {
                prev = i;
            }
        }
        return count;
    }
}
