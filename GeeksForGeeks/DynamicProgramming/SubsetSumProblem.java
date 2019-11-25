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



    public static void main(String[] args) {
        SubsetProblem subsetProblem = new SubsetProblem();

    }
}
