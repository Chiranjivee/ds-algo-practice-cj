class CountEvenLengthBinarySeqWithSameHalfSums {
    
    public int countSeqNaive(int n, int diff) {

        if (diff > n) {
            return 0;
        }

        int result = 0;

        // base case when number is 11 or 00
        if (n == 1 && diff == 0) {
            return 2;
        }

        // when number is 01 or 10
        if (n == 1 && Math.abs(diff) == 1) {
            return 1;
        }

        int res = 
            2 * countSeq(n - 1, diff) 
                + countSeq(n - 1, diff + 1)
                + countSeq(n - 1, diff - 1);
                
        return res;
    }
}
