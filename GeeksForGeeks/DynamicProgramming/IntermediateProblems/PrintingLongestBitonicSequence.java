class PrintingLongestBitonicSequence {
    public int findLongestBitonicSequence (int [] arr) {
        int n = arr.length;
        int [] dp1 = new int[n];
        int [] dp2 = new int[n];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        // find lis from left
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // find lis from right
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int result = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = dp1[i] + dp2[i] - 1;
            if (temp > result) {
                maxIndex = i;
                result = temp;
            }
        }

        printLIS(arr, dp1, maxIdx);
        printLDS(arr, dp2, maxIdx);

        return result;
    }

    public void printLIS(int [] arr, int [] dp, int maxIdx) {
        int count = 0;
        for (int i = 0; i < maxIdx; i++) {
            if (dp[i] > count) {
                count = dp[i];
                System.out.println(arr[i]);
            }
        }
    }

    public void printLDS(int [] arr, int [] dp, int maxIdx) {
        int count = dp[maxIdx];
        System.out.println(arr[maxIdx]);
        for (int i = maxIdx; i < arr.length; i++) {
            if (dp[i] < count) {
                count = dp[i];
                System.out.println(arr[i]);
            }
        }
    }
}
