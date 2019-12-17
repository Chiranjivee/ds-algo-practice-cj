class MaximumLengthChainOfPairs {

    // Assuming pair arr is sorted based on 'a'.
    public int getMaximumLengthChainOfPairs(Pair [] arr) {
        int [] dp = new int[arr.length + 1];
        Arrays.fill(dp, 1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i].a > arr[j].b && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}

class Pair {
    int a;
    int b;
}
