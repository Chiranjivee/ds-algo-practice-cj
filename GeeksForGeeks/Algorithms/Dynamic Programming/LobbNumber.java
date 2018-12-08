class LobbNumber {
    /**
     * Lobb number is defined as the number of
     * ways we can arrange (m + n) open parenthesis
     * and (m - n) closed parenthesis, to form the 
     * start of a valid sequence of balanced parenthesis 
     * 
     * e.g. m = 3 n = 2
     * 
     * m + n = 5 ( 
     * m - n = 1 )
     * 
     * (((( ()
     * (((() (
     * ((() ((
     * (() (((
     * () ((((
     * 
     * L(m, n) = (2m + 1) * (2n C m + n) / (m + n + 1)
     * 
     * 
     * @param m
     * @param n
     * @return
     */
    public static int lobb(int n, int m) {
        return (2 * m + 1) * binomialCoefficient(2 * n,  n + m) / (m + n + 1);
    }

    /**
     * Using pascals triangle.
     */
    public static int binomialCoefficient(int n, int r) {
        int [][] C = new int [n + 1][r + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || j == i) {
                    C[i][j] = 1;
                } else {
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                }
            }
        }
        System.out.println(n + " C " + r + ": " + C[n][r]);
        return C[n][r];
    }
    public static void main(String[] args) {
        System.out.println("Lobb(3, 2): " + lobb(3, 2));
    }
}