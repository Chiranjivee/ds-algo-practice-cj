class CoinChangeProblem {

    static int findCountOfWays(int [] coins, int index, int sum) {
        if (sum == 0) {
            return 1;
        }

        if (sum < 0) {
            return 0;
        }

        if (index <= 0 && sum > 1) {
            return 0;
        }

        return 
            findCountOfWays(coins, index - 1, sum)
            + findCountOfWays(coins, index, sum - coins[index - 1]);
    }

    static int findCountOfWaysBottomUp(int [] coins, int sum) {
        int [][] dp = new int[coins.length + 1][sum + 1];

        for (int i = 0; i < coins.length; i++) {
            int coinValue = coins[i];
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                }

                dp[i][j] = dp[i - 1][j] + dp[i][j - coinValue];
            }
        }

        return dp[coins.length][sum];
    }

    static int findCountOfWaysBottomUpSpaceOptimized(int [] coins, int sum) {
        int [] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            int coinValue = coins[i];
            for (int j = coinValue; j <= sum; j++) {
                dp[j] += dp[j - coinValue];
            }
        }

        return dp[sum];
    }
}
