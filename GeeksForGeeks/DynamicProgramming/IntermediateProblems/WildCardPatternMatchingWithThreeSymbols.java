// allowed chars are *, ?, +
class WildCardPatternMatching {
    public boolean matchPattern(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();

        if (m == 0) {
            return n == 0;
        }

        DP[][] dp = new DP[m + 1][n + 1];
        dp[0][0].value = true;

        for (int i = 1; i <= m; i++) {
            if (pattern.charAt(i - 1) == '*')
                dp[i][0].value = dp[i - 1][0].value;
        }

        // go over pattern
        for (int i = 1; i <= m; i++) {
            // go over string
            for (int j = 1; j <= n; j++) {
                if (pattern.charAt(i - 1) == '*') {
                    dp[i][j].value = dp[i - 1][j].value || dp[i - 1][j];
                    dp[i][j].ch = text.charAt(j - 1);
                } else if (pattern.charAt(i - 1) == '?') {
                    dp[i][j].value = dp[i - 1][j - 1].value;
                    dp[i][j].ch = text.charAt(j - 1);
                } else if (pattern.charAt(i - 1) == text.charAt(j - 1)) {
                    dp[i][j].value = dp[i - 1][j - 1];
                    dp[i][j].ch = text.charAt(j - 1);
                } else if (pattern.charAt(i - 1) == '+') {
                    // prev char not a symbol
                    if (pattern.charAt(i - 2) != '+' && pattern.charAt(i - 2) != '*' && pattern.charAt(i - 2) != '?') {
                        if (pattern.charAt(i - 2) == text.charAt(j - 1)) {
                            dp[i][j].value = dp[i - 1][j - 1].value;
                            dp[i][j].ch = text.charAt(j - 1);
                        }
                    } else if (text.charAt(j - 1) == dp[i - 1][j - 1].ch) {
                        dp[i][j].value = dp[i - 1][j - 1].value;
                        dp[i][j].ch = dp[i - 1][j - 1].ch;
                    } else {
                        dp[i][j].value = false;
                    }
                }
            }
        }

        return dp[m][n].value;
    }
}

class DP {
    boolean value = false;
    char c = '';
}
