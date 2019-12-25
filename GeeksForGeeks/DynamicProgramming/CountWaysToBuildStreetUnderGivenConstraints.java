class CountWaysToBuildStreetUnderGivenConstraints {

    /**
     * Given 2 * N
     */
    public int solve(int [][] arr) {

        int n = arr.length;
        int [][] dp = new int[2][n + 1];

        dp[0][1] = 1; // have H-H
        dp[1][1] = 2; // have H-O or H-H

        for (int i = 2; i <= n; i++) {

            dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
            dp[1][i] = 2 * dp[0][i - 1] + dp[1][i - 1];
        }

        return dp[0][n] + dp[1][n];
    }
}
