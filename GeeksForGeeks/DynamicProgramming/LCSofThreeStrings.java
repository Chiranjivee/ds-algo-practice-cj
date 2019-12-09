class LCSofThreeStrings {    
    int lcs(String one, String two, String three) {

        int [][][] dp = new int[one.length() + 1][two.length() + 1][three.length() + 1];

        for (int i = 0; i <= one.length(); i++) {
            for (int j = 0; j <= two.length(); j++) {
                for (int k = 0; k <= three.length(); k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        dp[i][j][k] = 0;
                    } else if (one.charAt(i - 1) == two.charAt(j - 1) && two.charAt(j - 1) == three.charAt(k - 1)) {
                        dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }
            }
        }

        return dp[one.length()][two.length()][three.length()];
    }
}
