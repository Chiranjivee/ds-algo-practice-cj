/**
 * Parity: Parity can have two values 0 or 1
 *         0 -> When number of 1's in the word is even.
 *         1 -> When number of 1's in the word is odd.
 */
class ComputeParity {

    /**
     *  Time Complexity: O(n).
     *  For every word this method will take O(n) time. We can 
     *  do better with a lookup table but a table with 2^64 entries is
     *  not allowed.
     */
    public int getParity(int x) {
        int result = 0;
        while (x != 0) {
            result ^= (x & 1);
            x >>>= 1;
        }
        return result;
    }

    /**
     * Time complexity: O(parity)
     * For every word keep flipping the lowest set bit and do
     * add with modulo 2. This is better than O(n), but we need to 
     * do better.
     */
    public int getParityWithBetterTimeComplexity(int x) {
        int result = 0;
        while (x != 0) {
            result ^= 1;
            x &= (x - 1); // Drops the lowest set bit.
        }
        return result;
    }

    /**
     * Time Complexity: O(n/wordSize)
     * Get parity for a 64 bit interger.
     * The lookup cache
     * Digit  Binary Parity
     * 0      - 0000 - 0
     * 1      - 0001 - 1
     * 2      - 0010 - 1
     * 3      - 0011 - 0
     * 4      - 0100 - 1
     * 5      - 0101 - 0
     * 6      - 0110 - 0
     * 7      - 0111 - 1
     * 8      - 1000 - 1
     * 9      - 1001 - 0
     * 10     - 1010 - 0
     * 11     - 1011 - 1
     * 12     - 1100 - 0
     * 13     - 1101 - 1
     * 14     - 1110 - 1
     * 15     - 1111 - 0
     * @param x
     * @return
     */
    public short getParityWithLookupCache(long x) {
        short[] lookup = { 0, 1, 1, 0,
                           1, 0, 0, 1,
                           1, 0, 0, 1,
                           0, 1, 1, 0 };
        final int wordSize = 16;
        final int mask = 0xFFFF;
        return 
            (short) 
                (lookup[(int) (x >>> 3 * wordSize & mask)] ^ 
                lookup[(int) (x >>> 2 * wordSize & mask)] ^ 
                lookup[(int) (x >>> wordSize & mask)] ^ 
                lookup[(int) (x & mask)]);
    }
    
    /**
     * Time Complexity: O(log(wordSize))
     * We know that the XOR of all the bits of a number 
     * is it's parity and also XOR is associative.
     * extract the last bit as it is the result
     * 
     * 11001101 -> 1100 ^ 1101 = 0001 -> 00 ^ 01 = 01 -> 0 ^ 1
     *          
     */
    public short getParityWithLogNComplexity(long x) {
        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        return (short) (x & 0x1); 
    }
    public static void main(String[] args) {
        int [] test = { 1, 2, 3, 4, 5 };
        ComputeParity parity = new ComputeParity();
        System.out.println("With linear complexity:");
        for (int x : test) {
            System.out.println(
                "Parity of " + x + " is: " + 
                    parity.getParity(x));
        }
        System.out.println("With better-linear complexity:");
        for (int y : test) {
            System.out.println(
                "Parity of " + y + " is: " + 
                    parity.getParityWithBetterTimeComplexity(y));
        }
        System.out.println("With O(n/l) complexity:");
        for (int z : test) {
            System.out.println(
                "Parity of " + z + " is: " + 
                    parity.getParityWithLookupCache(z));
        }

        System.out.println("With O(log(n)) complexity:");
        for (int z : test) {
            System.out.println(
                "Parity of " + z + " is: " + 
                    parity.getParityWithLogNComplexity(z));
        }
    }
}