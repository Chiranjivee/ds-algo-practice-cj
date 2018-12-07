class BellNumbers {

    /**
     * Bell number is defined as the total number of ways
     * you can partion a set sub sets of different sizes.
     * It is the sum of stirling number of second kind.
     */
    public static int getStirlingNK(int n, int k) {
        if (k <= 0 || k > n) return 0;
        if (n == 1 && k == 1) return 1;
        return getStirlingNK(n - 1, k - 1) + k * getStirlingNK(n - 1, k);    
    }

    public static int bellNumber(int n) {
        int bell = 0;
        for (int i = 1; i <= n; i++) {
            bell += getStirlingNK(n, i);
        }

        return bell;
    }

    public static void main(String[] args) {
        System.out.println("4th bell number: " + bellNumber(4));
    }
}