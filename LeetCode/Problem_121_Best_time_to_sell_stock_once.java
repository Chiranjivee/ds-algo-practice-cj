class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int globalProfit = 0;
        
        int minEndingHere = prices[0];
        
        for (int i = 0; i < prices.length; i++) {
            minEndingHere = Math.min(minEndingHere, prices[i]);
            int profit = prices[i] - minEndingHere;
            globalProfit = Math.max(globalProfit, profit);
        }
        
        return globalProfit;
    }
}
