class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int depth = 0, cur = 0, n = seq.length();
        for (int i = 0; i < n; ++i) {
            cur +=  seq.charAt(i) == '(' ?  1 : -1;
            depth = Math.max(depth, cur);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            if (seq.charAt(i) == '(') {
                if (++cur > depth / 2)
                    res[i] = 1;
            } else {
                if (cur-- > depth / 2)
                    res[i] = 1;
            }
        }
        return res;
    }
}
