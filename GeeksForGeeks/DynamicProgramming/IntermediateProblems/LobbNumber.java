/**
 * In combinatorial mathematics, the Lobb number Lm, n counts the number of ways that n + m open parentheses 
 * can be arranged to form the start of a valid sequence of balanced parentheses.
 * 
 * L(m,n) = [(2m + 1)/ (m + n + 1)] * C(2n, m + n)
 */
class LobbNumber {
    public int generateLobbNumber(int m, int n) {
        int x = 2 * m + 1;
        int y = m + n + 1;
        int z = binomialCoefficient(2 * n, m + n);

        return (x / y) * z;
    }

    public int binomialCoefficient(int n, int k) {
        int [][] dp = new int[n + 1][k + 1];

        // C(n, n) = C(n, 0) = 1;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (k == i || k == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[n][k];
    }
}
