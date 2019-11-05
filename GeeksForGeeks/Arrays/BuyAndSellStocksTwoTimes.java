class BuyAndSellStocksTwoTimes {
    public static void main(String[] args) {
        int price[] = {2, 30, 15, 10, 8, 25, 80};
        int [] profit = new int[price.length];


        int maxSoFar = price[price.length - 1];
        for (int i = price.length - 2; i >= 0; i++) {
            maxSoFar = Math.max(maxSoFar, price[i]);
            profit[i] = Math.max(profit[i + 1], maxSoFar - price[i]);
        }

        int minSoFar = price[0];
        for (int i = 1; i < price.length; i++) {
            minSoFar = Math.min(minSoFar, price[i]);
            profit[i] = Math.max(profit[i - 1], profit[i] + price[i] - minSoFar);
        }
    }
}
