class CountingBits {
    public int[] countBits(int num) {
        int [] res = new int[num + 1];
        if (num == 0) {
            res[0] = 0;
            return res;
        }

        if (num == 1) {
            res[0] = 0;
            res[1] = 1;
            return res;
        }
        
        res[0] = 0;
        res[1] = 1;

        for (int i = 2; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        
        return res;
    }
}
