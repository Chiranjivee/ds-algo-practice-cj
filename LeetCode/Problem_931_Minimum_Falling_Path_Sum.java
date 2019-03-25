import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[][] test = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(minFallingPathSum(test));
    }

    public static int minFallingPathSum(int[][] A) {
        if (A.length == 0)
            return 0;

        int[][] dp = new int[A.length][A.length];
        int size = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            dp[size][i] = A[size][i];
        }

        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j <= size; j++) {
                dp[i][j] = A[i][j];
                if (j == 0) {
                    dp[i][j] += Math.min(dp[i + 1][j + 1], dp[i + 1][j]);
                } else if (j == size) {
                    dp[i][j] += Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
                } else {
                    dp[i][j] += Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j - 1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= size; i++) {
            min = Math.min(min, dp[0][i]);
        }
        return min;
    }
}
