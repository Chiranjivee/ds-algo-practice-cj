class FindDistinctSubsetSumsOfArray {
    public void findDistinctSums(int [] arr) {

        int sum = getArraySum(arr);
        int n = arr.length;
        boolean [][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][arr[i - 1]] = true;
            for (int j = 1; j <= sum; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                    dp[i][j + arr[i - 1]] = true;
                }
            }
        }

        for (int i = 0; i <= sum; i++) {
            if (dp[n][i]) {
                System.out.println(i);
            }
        }
    }
}
