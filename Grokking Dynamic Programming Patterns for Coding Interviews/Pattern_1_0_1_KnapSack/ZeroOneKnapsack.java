class ZeroOneKnapsack {

    public int solveKnapsack(int [] weights, int [] profits, int totalBagWeight) {
        return solveKnapsackUtil(weights, profits, totalBagWeight, 0);
    }

    public int solveKnapsackUtil(int []  weights, int [] profits, int n, int idx) {
        if (n <= 0 || idx >= profits.length) {
            return 0;
        }

        // consider the current element
        int option1 = 0;
        // current one can be put in the bag take it
        if (weights[idx] <= n) {
            option1 = profits[idx] + solveKnapsackUtil(weights, profits, n - weights[idx], idx + 1);
        }

        // don't consider the current element
        int option2 = solveKnapsackUtil(weights, profits, n, idx + 1);


        return Math.max(option1, option2);
    }
    public static void main(String[] args) {

        ZeroOneKnapsack zeroOneKnapsack = new ZeroOneKnapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};

        int totalBagWeight = 7;
        int maxProfit = zeroOneKnapsack.solveKnapsack(weights, profits, totalBagWeight);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
