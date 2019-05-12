class ZeroOneKnapsack {

    public int solveKnapsack(int [] weights, int [] profits, int totalBagWeight) {
        return solveKnapsackUtil(weights, profits, totalBagWeight, 0);
    }

    private int knapsackRecursive(
        Integer[][] dp, 
        int[] profits, 
        int[] weights, 
        int capacity,
        int currentIndex) {

    // base checks
    if (capacity <= 0 || currentIndex >= profits.length)
      return 0;

    // if we have already solved a similar problem, return the result from memory
    if(dp[currentIndex][capacity] != null)
      return dp[currentIndex][capacity];

    // recursive call after choosing the element at the currentIndex
    // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
    int profit1 = 0;
    if( weights[currentIndex] <= capacity )
        profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights,
                capacity - weights[currentIndex], currentIndex + 1);

    // recursive call after excluding the element at the currentIndex
    int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);

    dp[currentIndex][capacity] = Math.max(profit1, profit2);
    return dp[currentIndex][capacity];
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
