class ReverseBits {

    /**
     *  0 -> 0000_0000_0000_0000
     *  1 -> 1000_0000_0000_0000
     *  2 -> 0100_0000_0000_0000
     *  3 -> 1100_0000_0000_0000
     *  4 -> 0010_0000_0000_0000
     *  5 -> 1010_0000_0000_0000
     *  6 -> 0110_0000_0000_0000
     *  7 -> 1110_0000_0000_0000
     *  8 -> 0001_0000_0000_0000
     *  9 -> 1001_0000_0000_0000
     * 10 -> 0101_0000_0000_0000
     * 11 -> 1101_0000_0000_0000
     * 12 -> 0011_0000_0000_0000
     * 13 -> 1011_0000_0000_0000
     * 14 -> 0111_0000_0000_0000
     * 15 -> 1111_0000_0000_0000
     * To be implemented
     */
    int [] lookup = {};
    public long reverse(long x) {
        final int WORDSIZE = 16;
        final int BIT_MASK = 0xFFFF;
        // this needs a look up table of size 2 ^ 16
        return 
            lookup[(int) (x & BIT_MASK)] << 3 * WORDSIZE | 
            lookup[(int) (x >>> WORDSIZE) & BIT_MASK] <<  2 * WORDSIZE | 
            lookup[(int) (x >>> 2 * WORDSIZE) & BIT_MASK] << WORDSIZE | 
            lookup[(int) (x >>> 3 * WORDSIZE) & BIT_MASK];
        
    }
}