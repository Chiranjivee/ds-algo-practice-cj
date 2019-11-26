/**
 * 
 * Given a set of non-negative integers, and a value sum, 
 * determine if there is a subset of the given set with sum equal to given sum.
 */
class SubsetProblem {

    public boolean isSubsetSum(int [] set, int target) {
        return isSubSetSum(set, 0, target);
    }

    public boolean isSubSetSum(int [] set, int idx, int target) {

        if (target == 0) {
            return true;
        }

        if (idx == set.length && target != 0) {
            return false;
        }

        return 
            isSubSetSum(set, idx + 1, target - set[idx]) 
            || isSubSetSum(set, idx + 1, target);
    }

    public boolean isSubSetSumMemoised(int [] set, int target) {

        int [][] dp = new int [target + 1][set.length];
        for (int i = 0; i < target + 1; i ++) {
            Arrays.fill(dp[i], -1);
        }

        return isSubSetSum(set, 0, target, dp) == 1;
    }

    public int isSubSetSum(int [] set, int idx, int target, int [][] dp) {

        if (dp[target][idx] != -1) {
            return dp[target][idx];
        }

        if (target == 0) {
            return dp[target][idx] = 1;
        }

        if (idx == set.length && target != 0) {
            return dp[target][idx] = 0;
        }

        return 
            dp[target][idx] = 
                Math.max(
                    isSubSetSum(set, idx + 1, target - set[idx]),
                    isSubSetSum(set, idx + 1, target));
    }

    public boolean isSubSetSumBottomUpDP(int [] set, int target) {

        boolean [][] dp = new boolean[set.length + 1][target + 1];

        // 0 sum is always possible
        for (int i = 0; i <= set.length; i++) {
            dp[i][0] = true;
        }

        // for empty set no sum is possible
        for (int i = 1; i <= target; i++) {
            dp[0][i] = false;
        }

        for (int elementIdx = 1; elementIdx <= set.length; i++) {
            for (int currentSum = 1; currentSum <= target; currentSum++) {
                if (currentSum > set[elementIdx - 1]) {
                    dp[elementIdx][currentSum] = dp[elementIdx - 1][currentSum];
                } else {
                    dp[elementIdx][currentSum] = 
                        dp[elementIdx - 1][currentSum]                                  // exclude element
                            || dp[elementIdx - 1][currentSum - set[elementIdx - 1]]     // include element
                }
            }
        }

        return dp[set.length][target];
    }

    public boolean isSubSetBottomUpSpaceOptimized(int [] set, int target) {

        boolean [][] dp = new boolean[2][target + 1];

        int elementIdx = 0;
        for (; elementIdx <= set.length; elementIdx++) {
            for (int currentSum = 0; currentSum <= target; currentSum++) {
                if (elementIdx == 0) {
                    dp[elementIdx][currentSum] = false;
                } else if (currentSum == 0) {
                    dp[elementIdx % 2][currentSum] = true;
                } else if (currentSum < set[elementIdx - 1]) {
                    dp[elementIdx % 2][currentSum] = dp[(elementIdx + 1) % 2][currentSum];
                } else {
                    dp[elementIdx % 2][currentSum] =
                        dp[(elementIdx + 1) % 2][currentSum] ||
                        dp[(elementIdx + 1) % 2][currentSum - set[elementIdx - 1]];
                }
            }
        }

        return dp[set.length % 2][target];
    }
}
