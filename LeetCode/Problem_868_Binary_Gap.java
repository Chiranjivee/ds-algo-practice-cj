class Solution {
    public int binaryGap(int N) {
        String x = Integer.toBinaryString(N);
        int lastOneIdx = -1;
        int res = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '1') {
                if (lastOneIdx != -1) {
                    res = Math.max(res, i - lastOneIdx);
                }
                lastOneIdx = i;
            }
        }
        return res;
    }
}
