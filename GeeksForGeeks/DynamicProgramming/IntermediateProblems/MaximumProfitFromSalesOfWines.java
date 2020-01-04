class MaximumProfitFromSalesOfWines {
    // assume filled with -1
    static int dp[][] = new int[100][100];
    int maxProfitUtil(int [] prices, int begin, int end, int n) {
        if (dp[begin][end] != -1) {
            return dp[begin][end];
        }

        int year = n - (end - begin);

        if (begin == end) {
            return year * prices[end];
        }

        int optionOne = year * prices[begin] + maxProfitUtil(prices, begin + 1, end, n);
        int optionTwo = year * prices[end] + maxProfitUtil(prices, begin, end - 1, n);

        int ans = Math.max(optionOne, optionTwo);
        dp[begin][end] = ans;

        if (optionOne > optionTwo) {
            sell[begin][end] = 1;
        } else {
            sell[begin][end] = 0;
        }

        return ans;
    }

    int maxProfit(int [] prices) {
        int n = prices.length;
        int res = maxProfitUtil(prices, 0, n - 1, n);
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            if (sell[i][j] == 1) {
                System.out.println("Beginning");
                i++;
            } else {
                System.out.println("End");
                j--;
            }
        }

        return res;
    }
}
