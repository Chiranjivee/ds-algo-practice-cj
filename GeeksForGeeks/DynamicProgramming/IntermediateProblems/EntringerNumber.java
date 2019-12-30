/**
 * The Entringer Number E(n, k) are the number of permutations of {1, 2, …, n + 1}, starting with k + 1, 
 * which, after initially falling, alternatively fall then rise. The Entringer are given by:
 * 
 */
class EntringerNumber {
    public int getEntringerNumber(int n, int k) {
        if (n == 0 && k == 0) {
            return 1;
        }

        if (k == 0) {
            return 0;
        }

        return getEntringerNumber(n, k - 1) + getEntringerNumber(n - 1, n - k);
    }

    public int getEntringerNumberDP(int n, int k) {
        int [][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][i - j];
                }
            }
        }

        return dp[n][k];
    }
}
