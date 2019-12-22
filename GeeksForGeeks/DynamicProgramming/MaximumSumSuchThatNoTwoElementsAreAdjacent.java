class MaximumSumSuchThatNoTwoElementsAreAdjacent {
    public int getMaxSumWithNoAdjacent(int [] arr) {
        int [] dp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                dp[i] = arr[i];
            } else if (i == 1) {
                dp[i] = Math.max(arr[i], arr[i - 1]);
            } else {
                dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
            }
        }

        return dp[arr.length - 1];
    }


    public int getMaxWithConstantSpace(int [] arr) {
        
        if (arr.length == 0) {
            return 0;
        }

        if (arr.length == 1) {
            return arr[0];
        }

        int secLast = arr[0];
        int last = Math.max(arr[0], arr[1]);

        int result = last;
        for (int i = 2; i < arr.length; i++) {
            result = Math.max(last, arr[i] + secLast);
            secLast = last;
            last = result;
        }

        return result;
    }
}
