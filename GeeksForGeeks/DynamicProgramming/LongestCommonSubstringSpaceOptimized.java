class LongestCommonSubstring {
    public int getLCSLength(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int [][] dp = new int[2][n];
        int currentRow = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[currentRow][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[currentRow][j] = 1 + dp[1 - currentRow][j - 1];
                } else {
                    dp[currentRow][j] = 0
                }

                res = Math.max(res, dp[i][j]);
                currentRow = 1 - currentRow;
            }
        }

        return res;   
    }
}
