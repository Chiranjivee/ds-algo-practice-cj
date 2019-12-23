import java.utils.Arrays;

class MinimumRemovalOfElementsFromArrayToMakeMaxMinusMinLessThanEqualToK {

    public int solve(int [] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int [][] dp = new int[n][n];
        return solveDP(arr, 0, n - 1, dp);
    }

    public int solveDP(int [] arr, int i, int j, int [][] dp) {
        if (i >= j) {
            return 0;
        }

        if (arr[j] - arr[i] <= k) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = 1 + Math.min(solveDP(arr, i + 1, j, dp), solveDP(arr, i, j - 1, dp));
    }
}
