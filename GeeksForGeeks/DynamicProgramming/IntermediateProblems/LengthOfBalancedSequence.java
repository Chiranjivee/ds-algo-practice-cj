class LengthOfBalancedSequence {
    public int getLengthOfBalancedSeq(String s) {
        int n = s.length();
        int [][] dp = new int[n][n];


        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '(' && s.charAt(i  +  1) == ')') {
                dp[i][i + 1] = 2;
            }
        }

        for (int l = 2; l < n; l++) {
            for (int i = 0, j = 1; j < n; i++, j++) {
                if (s.charAt(i) == '(' && s.charAt(j) == ')') {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                }

                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
            }
        }

        return dp[n][n];
    }
}
