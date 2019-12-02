class CuttingARod {

    public int cutRodForMaxValue(int rodSize, int [] price, int [] dp) {

        if (rodSize <= 0) {
            return 0;
        }
        if (dp[rodSize] != 0) {
            return dp[rodSize];
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i < rodSize; i++) {
            result = Math.max(result, price[rodSize] + cutRodForMaxValue(rodSize - i, price));
        }

        return dp[rodSize] = result;
    }

    public int cutRodForMaxValueBottomUp(int rodSize, int [] price) {
        int [] dp = new int [rodSize + 1];

        for (int i = 1; i <= rodSize; i++) {
            int result = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                result = Math.max(result, price[j] + dp[i - j]);
            }

            dp[i] = result;
        }

        return dp[rodSize];
    }
}