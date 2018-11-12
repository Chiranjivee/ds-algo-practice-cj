class SwapBits {

    /**
     * Time complexity: O(1)
     * Algorithm: Check if the bit needs to be swapped.
     * If yes, swap using mask and XOR it to flip the bits
     * required position.
     *
     * @param x
     * @param i
     * @param j
     * @return
     */
    public long swapBit(long number, int i, int j) {
        if (((number >>> i) & 1) != ((number >>> j) & 1)) {
            long bitMask = (1L << i) | (1L << j);
            number ^= bitMask;
        }
        return number;
    }
    public static void main(String[] args) { 
        SwapBits bitSwapper = new SwapBits();
        long [] input = { 10, 67, 95, 100 }; // 1010
        for (long x : input) {
            System.out.println(
                "Swap 2nd and 13th bit in " + x + " : " + 
                    bitSwapper.swapBit(x, 2, 13));
        }
    }
}