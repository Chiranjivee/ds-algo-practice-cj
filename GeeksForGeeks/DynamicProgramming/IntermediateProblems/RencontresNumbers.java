/**
 * Given two numbers, n >= 0 and 0 <= k <= n, count the number of derangements with k fixed points
 */
class RencontresNumbers {
    // base cases: 
    public int getRencontresNumbers(int n, int k) {
        if (n == 0 && k == 0) {
            return 1;
        }

        if (n == 1 && k == 0) {
            return 0;
        }

        if (k == 0) {
            return (n - 1) * (getRencontresNumbers(n - 2, 0) + getRencontresNumbers(n - 1, 0));
        } else {
            return binomialCoefficient(n, k) * getRencontresNumbers(n - k, 0);
        }
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
