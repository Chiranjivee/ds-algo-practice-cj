class Solution {
    public int getMaxSum(int [][] mat) {
        int [][] dp = new int[max.length][max[0].length];

        for (int i = 0; i < mat[0].length; i++) {
            dp[mat.length - 1][i] = mat[mat.length - 1][i];
        }

        for (int i = mat.length - 2; i >= 0; i--) {
            for (int j = 0; j < mat[0].length; j++) {
                if (j == mat[0].length - 1) {
                    dp[i][j] += dp[i + 1][j];        
                } else {
                    dp[i][j] += (dp[i + 1][j] + dp[i + 1][j + 1]);
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0 ; i < mat[0].length; i++) {
            res = Math.max(res, dp[0][i]);
        }

        return res;
    }
}