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
    public static void main(String[] args) {
        int [] test = { 1, 2, 3, 4, 5 };
        ComputeParity parity = new ComputeParity();
        for (int x : test) {
            System.out.println(
                "Parity of " + test[x] + " is: " + 
                    parity.getParity(x));
        }

        for (int x : test) {
            System.out.println(
                "Parity of " + test[x] + " is: " + 
                    parity.getParityWithBetterTimeComplexity(x));
        }
    }
}