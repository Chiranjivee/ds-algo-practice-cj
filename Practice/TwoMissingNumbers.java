class TwoMissingNumbers {
    public static void main(String[] args) {
        int n = 6;
        int [] actual = { 0, 1, 2, 3 };

        int xor = 0;
        // Compute xor of the given element array
        for (int i = 0; i < actual.length; i++) {
            xor ^= actual[i];
        }

        // Compute xor of all the possible elements in range [0, n - 1] inclusive.
        for (int i = 0; i < n; i++) {
            xor ^= i;
        }

        // At this point of time our xor will contain the xor of two missing elements.
        // We need a way to identify these two elements. In this xor, a set bit represents
        // that this bit is different in both element, by this concept we can partition the
        // input set of array and the range in two sets, on containg the set bit at the right
        // most element and on containing the same bit but off.
        int rightMostSetBit = xor & ~(xor - 1);
        int x = 0; 
        int y = 0;
        for (int i = 0; i < actual.length; i++) {
            if ((actual[i] & rightMostSetBit) > 0) {
                x ^= actual[i];
            } else {
                y ^= actual[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if ((i & rightMostSetBit) > 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        System.out.println("X is: " + x);
        System.out.println("Y is: " + y);
    }
}
