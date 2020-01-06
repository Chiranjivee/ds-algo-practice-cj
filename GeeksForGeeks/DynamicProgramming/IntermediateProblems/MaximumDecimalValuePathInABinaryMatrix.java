class MaximumDecimalValuePathInABinaryMatrix {
    static int MaximumDecimalValue(int mat[][], int n) {
        int dp[][] = new int[n][n];
        if (mat[0][0] == 1) {
            dp[0][0] = 1; // 1*(2^0)
        }

        for (int i = 1; i < n; i++) {
            // indicate 1*(2^i) + result of previous
            if (mat[0][i] == 1) {
                dp[0][i] = (int) (dp[0][i - 1] + Math.pow(2, i));
            } // indicate 0*(2^i) + result of previous
            else {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < n; i++) {
            // indicate 1*(2^i) + result of previous
            if (mat[i][0] == 1) {
                dp[i][0] = (int) (dp[i - 1][0] + Math.pow(2, i));
            } // indicate 0*(2^i) + result of previous
            else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                // Here (i+j) indicate the current power of
                // 2 in path that is 2^(i+j)
                if (mat[i][j] == 1) {
                    dp[i][j] = (int) (Math.max(dp[i][j - 1], dp[i - 1][j]) + Math.pow(2, i + j));
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n - 1][n - 1];
    }
}
