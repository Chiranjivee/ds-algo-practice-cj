class SubsetSumDivisibleByM {
    public boolean isSubsetSumDivisibleByM(int [] set, int m) {
        for (int i = 0; i < set.length; i++) {
            set[i] %= m;
            if (set[i] == 0) {
                return true;
            }
        }

        return isSubSetBottomUpSpaceOptimized(set, m);
    }

    public boolean isSubSetBottomUpSpaceOptimized(int [] set, int target) {

        boolean dp[][] = new boolean[2][target + 1];
        
        int n = set.length;
        for (int elementIdx = 0; elementIdx <= n; elementIdx++) {
            for (int currentSum = 0; currentSum <= target; currentSum++) {
                if (currentSum == 0) {
                    dp[elementIdx % 2][currentSum] = true;
                } else if (elementIdx == 0) {
                    dp[elementIdx][currentSum] = false;
                } else if (set[elementIdx - 1] <= currentSum) {
                    dp[elementIdx % 2][currentSum] =
                        dp[(elementIdx + 1) % 2][currentSum - set[elementIdx - 1]] ||
                        dp[(elementIdx + 1) % 2][currentSum];
                } else {
                    dp[elementIdx % 2][currentSum] = dp[(elementIdx + 1) % 2][currentSum];
                }
            }
        }

        return dp[n % 2][target];
    }
}
