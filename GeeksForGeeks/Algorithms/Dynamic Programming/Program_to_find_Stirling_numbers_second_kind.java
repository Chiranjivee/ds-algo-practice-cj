class StirlingNumbersSecondKind {

    /**
     * Stirling number is defined as the number of ways
     * you can partion a set in k non-empty sub sets
     */
    public static int getStirlingNK(int n, int k) {
        if (k <= 0 || k > n) return 0;
        if (n == 1 && k == 1) return 1;
        return getStirlingNK(n - 1, k - 1) + k * getStirlingNK(n - 1, k);    
    }

    public static void main(String[] args) {
        System.out.println("Stirling(4, 2): " + getStirlingNK(4, 2));
    }
}