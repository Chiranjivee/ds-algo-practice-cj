class LargestSumZigZagSequenceInMatrix {
    public int largestSum(int [][] arr, int [][] dp, int i, int j) {
        if (i == arr.length - 1) {
            return dp[i][j] = arr[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int max = Integer.MIN_VALUE;
        for (int x = 0; x < arr[i].length; x++) {
            if (x != j) {
                max = Math.max(max, largestSum(arr, dp, i + 1, x));
            }
        }

        return dp[i][j] = arr[i][j] + max;
    }
}
