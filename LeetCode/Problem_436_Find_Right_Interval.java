class Solution {
    class Interval {
        int start;
        int end;
        
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[] findRightInterval(int[][] intervals) {
        Interval [] inter = new Interval[intervals.length];
        int j = 0;
        for (int [] i: intervals) {
            inter[j++] = new Interval(i[0], i[1]); 
        }
        return findRightInterval(inter);
    }
    
    public Interval binary_search(Interval[] intervals, int target, int start, int end) {
        if (start >= end) {
            if (intervals[start].start >= target) {
                return intervals[start];
            }
            return null;
        }
        int mid = (start + end) / 2;
        if (intervals[mid].start < target) {
            return binary_search(intervals, target, mid + 1, end);
        } else {
            return binary_search(intervals, target, start, mid);
        }
    }

    public int[] findRightInterval(Interval[] intervals) {
        int[] res = new int[intervals.length];
        HashMap<Interval, Integer> hash = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            hash.put(intervals[i], i);
        }
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        for (int i = 0; i < intervals.length; i++) {
            Interval interval = binary_search(intervals, intervals[i].end, 0, intervals.length - 1);
            res[hash.get(intervals[i])] = interval == null ? -1 : hash.get(interval);
        }
        return res;
    }
}
