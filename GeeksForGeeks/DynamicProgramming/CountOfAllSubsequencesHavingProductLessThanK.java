class CountOfAllSubsequencesHavingProductLessThanK {

    public int getCountOfAllSubsequencesHavingProductLessThanK(int [] arr, int k) {
        return util(arr, 1, k, 0);
    }

    public int util(int [] arr, int product, int k, int idx) {
        if (idx == arr.length()) {
            if (product < k) {
                return 1;
            } else {
                return 0;
            }
        }

        if (product > k) {
            return 0;
        }

        int option1 = util(arr, product * arr[idx], k, idx + 1);
        int option2 = util(arr, product, k, idx + 1);

        return option1 + option2;
    }

    public int getCountOfAllSubsequencesHavingProductLessThanKBottomUpDP(int [] arr, int k) {
        int [][] dp = new int[k + 1][arr.length + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (arr[j - 1] < i && arr[j - 1] > 0) {
                    dp[i][j] += dp[i / arr[j - 1]] + 1;
                }
            }
        }

        return dp[k][n];
    }
}
