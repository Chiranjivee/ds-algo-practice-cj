class UnboundedKnapsack {
    public int unboundedKnapsack(int [] weight, int [] value, int k) {
        int [] dp = new int[k + 1];
        
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= k; j++) {
                if (weight[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }

        return dp[k];
    }
}
