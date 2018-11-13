class ClosestInteger {
    static final int UNSIGNED_BIT = 63;
    public static long closestIntSameBitCount (long x) throws IllegalArgumentException {
        for (int i = 0; i < UNSIGNED_BIT - 1; i++) {
            if (((x >>> i) & 1) != ((x >>> i + 1) & 1)) {
                x ^= 1L << i | 1L << i + 1;
                return x;
            }
        }

        throw new IllegalArgumentException("All bits are 0 or 1");
    }
    public static void main(String[] args) throws IllegalArgumentException {
        long x = 6;
        System.out.println("Closest weight integer to " + x + ":" + closestIntSameBitCount(x));
    }
}