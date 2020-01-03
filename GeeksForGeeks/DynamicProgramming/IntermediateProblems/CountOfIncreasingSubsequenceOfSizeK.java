class CountOfIncreasingSubsequenceOfSizeK {
    public int getCountOfIncreasingSubsequenceOfSizeK(int [] arr, int k) {
        int [][] dp = new int[k][n];

        for (int i = 0; i < arr.length; i++) {
            dp[0][i] = 1;
        }

        for (int l = 1; l < k; l++) {
            for (int i = 1; i < n; i++ ) {
                for (int j = l - 1; j < i; j++) {
                    if (arr[j] < arr[i]) {
                        dp[l][i] += dp[l - 1][j];
                    }
                }
            }
        }
        int sum = 0;
        // sum all the seq with size k
        for (int i = k - 1; i < n; i++) {
            sum += dp[k - 1][i];
        }

        return sum;
    }
}
