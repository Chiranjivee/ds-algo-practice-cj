class CountBits {

    /**
     * Time complexity: O(n)
     * @param x
     * @return
     */
    public int countBits(int x) {
        int bitCount = 0;
        while (x > 0) {
            bitCount += x & 1; // And with 1 
            x = x >>> 1; // right shift with zeros 
        }
        return bitCount;
    }
    public static void main(String[] args) {
        CountBits bits = new CountBits();
        int [] test = {1, 2, 3, 4, 5, 0};

        for (int i = 0; i < test.length; i++) {
            System.out.println(
                "Bits in " + test[i] + " is: " + bits.countBits(test[i]));
        }
    }
}