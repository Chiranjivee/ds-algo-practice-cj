class RemoveArrayEndElementToMaximizeSumOfProduct {
    public int solve(int [] arr) {
        int [][] dp = new int[arr.length][arr.length];
        return solveUtil(arr, 0, n - 1, dp, 1);
    }

    public int solveUtil(int [] arr, int low, int high, int [][] dp, int turn) {
        if (low == high) {
            return arr[low] * turn;
        }

        if (dp[low][high] != -1) {
            return dp[low][high];
        }

        int optionOne = (arr[low] * turn) + solveUtil(arr, low + 1, high, dp, turn + 1);
        int optionTwo = (arr[high] * turn) + solveUtil(arr, low, high - 1, dp, turn + 1);

        return dp[low][high] = Math.max(optionOne, optionTwo);
    }
}
