class ComputeNcRModP {
    /**
     * NCR(n, r) = NCR(n - 1, r - 1) + NCR(n - 1, r)
     * NCR(n, 0) = NCR(n, n) = 1;
     */
    public int computeNCRMODP(int n, int r, int p) {
        int [] C = new int[r + 1];

        C[0] = 1;

        for (int i = 1; i <= n; i++) {
            // have to fill the array backwards as we want to use the current and prev res
            for (int j = Math.min(i, r); j >= 1; j--) {

                C[j] = (C[j - 1] + C[j]) % p;
            }
        }

        return C[r];
    }

    public static void main(String[] args) {
        ComputeNcRModP sol = new ComputeNcRModP();
        int result = sol.computeNCRMODP(13, 4, 5);
        System.out.println("NCR(13, 4, 5): " + result);
    }
}
