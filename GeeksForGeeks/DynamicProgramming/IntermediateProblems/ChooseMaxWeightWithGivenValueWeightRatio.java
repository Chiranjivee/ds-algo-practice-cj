class Solution {
    static int maxWeightRec(int wt[], int val[], int K, HashMap<Point, Integer> hm, int last, int diff) {
        if (last == -1) {
            if (diff == 0) {
                return 0;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        Point tmp = new Point(last, diff);
        if (hm.containsKey(tmp)) {
            return hm.get(tmp);
        }

        hm.put(
            tmp,
            Math.max(
                maxWeightRec(wt, val, K, hm, last - 1, diff),
                wt[last] + maxWeightRec(wt, val, K, hm, last - 1, diff + wt[last] - val[last] * K)));

        return hm.get(tmp);
    }
}
