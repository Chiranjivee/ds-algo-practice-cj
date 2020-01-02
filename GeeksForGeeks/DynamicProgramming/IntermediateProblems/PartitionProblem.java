/**
 * Partition problem is to determine whether a given set can be partitioned into two subsets 
 * such that the sum of elements in both subsets is same
 */
class PartitionProblem {
    public boolean canSetBePartitioned(int [] arr) {
        if (arr.length == 1) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int targetSum = sum/2;
        return isTargetSumPossible(arr, targetSum);
    }

    public boolean isTargetSumPossible(int [] arr, int targetSum, int idx) {
        int [][] dp = new int[arr.length + 1][targetSum + 1];
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = arr[i - 1]; j <= targetSum; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i - 1]]);
            }
        }

        return dp[arr.length][targetSum] == 1;
    }
}
