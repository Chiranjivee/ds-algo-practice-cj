class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[] sell = new int[n];
        int[] buy = new int[n];
        sell[0] = 0;
        buy[0] = prices[0] * -1;
        for (int i = 1; i < n; i++){
           // max profit equals to  buy it 1 day before, and sell it today
           sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]); 
           // if we sell it 2 days before, what is the best buy prices
           buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0) - prices[i]);  
        }
        return sell[n-1];
    }
}
