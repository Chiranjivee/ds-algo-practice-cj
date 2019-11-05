class NthCatalan {
    public long getNthCatalan(int n) {
        long result = binomialCoefficient(2 * n, n) / (n + 1);
        return result;
    }

    public long binomialCoefficient(int n, int k) {
        long result = 1;
        if (k > n - k) {
            k = n - k;
        }

        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        NthCatalan nthC = new NthCatalan();
        int n = 0;
        System.out.println("Catalan " + n + " : " + nthC.getNthCatalan(n));
    }
}
