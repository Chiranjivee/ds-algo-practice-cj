class PrintingAllLongestCommonSubsequence {
    public void printAllLCS(String s1, String s2) {
        int [][] dp = longestCommonSubsequence(s1, s2);
        List<String> set = findLCSRec(s1, s2, dp, s1.length(), s2.length());
        for (String s : set) {
            System.out.println(s);
        }
    }

    List<String> findLCSRec(String s1, String s2, int[][] dp, int m, int n) {
        List<String> set = new ArrayList<>();

        if (m == 0 || n == 0) {
            set.add("");
            return set;
        }

        if (s1.charAt(m - 1) == s2.charAt(m - 2)) {
            List<String> set2 = findLCSRec(s1, s2, dp, m - 1, n - 1);
            for (String s : set2) {
                set.add(s + s1.charAt(m - 1));
            }
            return set;
        } else {
            if (dp[m - 1][n] >= dp[m][n - 1]) {
                set = findLCSRec(s1, s2, dp, m - 1, n);
            } else {
                set = findLCSRec(s1, s2, dp, m, n - 1);
            }
        }

        return set;
    }

    int[][] longestCommonSubsequence(String s1, String s2) {
        int [][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp;
    }
}