class DiceThrow {
    public int getWays(int dices, int faces, int sum) {

        int [][] dp = new int[dices + 1][sum + 1];
        for (int i = 1; i <= faces && i <= sum; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= dices; i++) {
            for (int j = 1; j <= sum; j++) {
                for (int k = 1; k <= faces; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        return dp[dices][sum];
    }
}
