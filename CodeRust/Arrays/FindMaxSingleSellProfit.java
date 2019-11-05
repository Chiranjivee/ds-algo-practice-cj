class FindMaxSingleSellProfit {
    public static Tuple find_buy_sell_stock_prices(int[] array) {
        if (array == null || array.length < 2) {
            return null;
        }

        int current_buy = array[0];
        int global_sell = array[1];
        int global_profit = global_sell - current_buy;

        int current_profit = Integer.MIN_VALUE;

        for (int i = 1; i < array.length; i++) {
            current_profit = array[i] - current_buy;

            if (current_profit > global_profit) {
                global_profit = current_profit;
                global_sell = array[i];
            }

            if (current_buy > array[i]) {
                current_buy = array[i];
            }
        }

        Tuple<Integer, Integer> result = new Tuple<Integer, Integer>(global_sell - global_profit, // buy price
                global_sell // sell price
        );

        return result;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 3, 2, 1, 2, 5 };
        Tuple result = null;
        result = find_buy_sell_stock_prices(array);
        System.out.println(String.format("Buy Price: %d Sell Price: %d", result.x, result.y));

        int[] array2 = { 12, 5, 9, 19, 8 };
        result = find_buy_sell_stock_prices(array2);
        System.out.println(String.format("Buy Price: %d Sell Price: %d", result.x, result.y));

    }
}
