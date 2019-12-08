class SpaceOptimizedLCS {

    /**
     * My way
     */
    public int spaceOptimizedLCS(String s1, String s2) {
        int [][] dp = new int[2][s2.length + 1];

        for (int i = 0; i <= s1.length; i++) {
            for (int j = 0; j <= s2.lenght; j++) {
                if (i == 0 || j == 0) {
                    dp[i % 2][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i % 2][j] = 1 + dp[(i + 1) % 2][j];
                } else {
                    dp[i % 2][j] = Math.max(dp[i % 2][j - 1], dp[(i + 1) % 2][j]);
                }
            }
        }

        return dp[s1.length % 2][j];
    }
}
