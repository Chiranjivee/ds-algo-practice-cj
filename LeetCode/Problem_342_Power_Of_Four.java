class Solution {

    /**
     * // m = num &Ox55555555, keep all ones which could make num to be the power of
     * four // k = num & (num - 1), clear least significant bit with one // if m ==
     * 0 and k != 0, then the num is power of four
     * 
     * Eg. 16 -> 10000 10000 & 0101 0101 0101 0101 0101 0101 0101 0101 -> 0000 0000
     * 0000 0000 0000 0000 0001 0000, true, not zero 1000 & 0111 -> 0000, true, is
     * zero return true
     * 
     * Eg. 32 -> 100000 10 0000 & 0101 0101 0101 0101 0101 0101 0101 0101 -> 0000
     * 0000 0000 0000 0000 0000 0000 0000, false, this should be non zero in order
     * to be power of four. 10 0000 && (01 1111) -> 0, true, is zero return false
     * 
     * Eg. 19 -> 10010 1 0011 & 0101 0101 0101 0101 0101 0101 0101 0101 -> 0000 0000
     * 0000 0000 0000 0000 0001 0001, true, not zero 1 0011 && (1 0010) -> 1 0010,
     * false, not zero return false/
     * 
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {

        // 0x55555555 is to get rid of those power of 2 but not power of 4
        // so that the single 1 bit always appears at the odd position
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;

    }
}
