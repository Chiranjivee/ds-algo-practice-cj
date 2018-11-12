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
    public static void main(String[] args) {

    }
}