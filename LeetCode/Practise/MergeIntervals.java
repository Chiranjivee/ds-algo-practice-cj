class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ret = new ArrayList<>();
        int[] prev = null;
        for (int[] inter : intervals) {
            //if prev is null or curr.start > prev.end, add the interval
            if (prev==null || inter[0] > prev[1]) {
                ret.add(inter);
                prev = inter;
            } else if (inter[1] > prev[1]) {
                // curr.end > prev.end, modify the element already in list
                prev[1] = inter[1];
            }
        }

        return ret.toArray(new int[ret.size()][2]);
    }
}
