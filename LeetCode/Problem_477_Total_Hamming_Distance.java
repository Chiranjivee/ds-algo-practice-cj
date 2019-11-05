class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int zc = 0;
            int oc = 0;

            for (int x:nums) {
                long a = x & (1 << i);
                if(a > 0)oc++;
                else zc++;
            }

            res += (zc * oc);
        }

        return res;
    }
}
