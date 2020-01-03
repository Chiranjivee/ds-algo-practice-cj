class CoinGameWinner {
    public boolean whoWins(int n, int x, int y) {
        int[] dp = new int[n + 1];
        dp[0] = false;
        dp[1] = true;

        for (int i = 2; i < n + 1; i++) {
            if (i - 1 >= 0 && dp[i - 1] == false) {
                dp[i] = true;
            } else if (i - x >= 0 && dp[i - x] == false) {
                dp[i] = true;
            } else if (i - y >= 0 && dp[i - y] == false) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }

        return dp[n];
    }
}
