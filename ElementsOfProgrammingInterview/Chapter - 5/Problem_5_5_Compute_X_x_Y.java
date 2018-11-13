class Multiply {
    public static long multiply(long x, long y) {
        long sum = 0;
        while (x != 0) {
            if ((x & 1) != 0) {
                sum = add(sum, y);
            }
            x >>>= 1;
            y <<= 1;
        }
        return sum;
    }

    public static long add(long a, long b) {
        long sum = 0;
        long carryIn = 0;
        long k = 1;
        long tempA = a;
        long tempB = b;

        while (tempA != 0 || tempB != 0) {
            long ak = a & k;
            long bk = b & k;
            long carryOut = (ak & bk) | (ak & carryIn) | (bk & carryIn);
            sum |= ak ^ bk ^ carryIn;
            carryIn = carryOut << 1;
            k <<=1;
            tempA >>>=1;
            tempB >>>=1;
        }
        return sum | carryin;

    }
    public static void main(String[] args) {
        System.out.println("Multiply 3 * 5: " + multiply(3, 5));
    }
}