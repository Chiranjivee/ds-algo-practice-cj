class MaxProfitByBuyingSellingShareAtMostTwice {
    public int solve(int [] arr) {
        int n = arr.length - 1;
        int [] dp = new int[arr.length + 1];
        int maxPrice = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxPrice) {
                maxPrice = arr[i];
            }

            dp[i] = Math.max(dp[i + 1], maxPrice - price[i]);
        }

        int minPrice = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < minPrice) {
                minPrice = arr[i];
            }

            dp[i] = Math.max(dp[i - 1], arr[i] - minPrice);
        }

        int result = dp[n - 1];
        return result;
    }
}
