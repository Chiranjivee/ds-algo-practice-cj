class LongestCommonSubsequence {
    public static void main(String[] args){ 
        String s1 = "Tasty";
        String s2 = "Test";

        System.out.println(lcsRecursive(s1, s2));
        System.out.println(lcsMemoised(s1, s2));
    }

    public static int lcsRecursive(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return 0;
        }

        if (s1.charAt(0) == s2.charAt(0)) {
            return 1 + lcsRecursive(s1.substring(1), s2.substring(1));
        } else {
            int option1 = lcsRecursive(s1.substring(1), s2);
            int option2 = lcsRecursive(s1, s2.substring(1));

            return Math.max(option1, option2);
        }
    }

    public static int lcsMemoised(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int [][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        int result = lcsMemoised(s1, s2, m, n, dp);
        return result;
    }


    public static int lcsMemoised(String s1, String s2, int m, int n, int [][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (dp[m][n] > -1) {
            return dp[m][n];
        }

        if (s1.charAt(0) == s2.charAt(0)) {
            int opt = 1 + lcsMemoised(s1.substring(1), s2.substring(1), m - 1, n - 1, dp);
            dp[m][n] = opt;
            return opt;
        } else {
            int option1 = lcsMemoised(s1.substring(1), s2, m - 1, n, dp);
            int option2 = lcsMemoised(s1, s2.substring(1), m, n - 1, dp);
            dp[m][n] = Math.max(option1, option2);
            return dp[m][n];
        }
    }
}