class MinimumStepsToMinimizeN {
    public int minimizeN(int n) {
        if (n == 1) {
            return 1;
        }

        if (n % 2 == 0) {
            return 1 + minimizeN(n / 2);
        } else if (n % 3 == 0) {
            return 1 + minimizeN(n / 3);
        } else {
            return 1 + minimizeN(n - 1);
        }
    }

    public int minimizeN(int n, int dp) {
        if (n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int res = Integer.MAX_VALUE;
        int option1 = minimizeN(n - 1, dp);
        res = Math.min(res, option1);

        if (n % 2 == 0) {
            int option2 = minimizeN(n / 2, dp);
            res = Math.min(res, option2);
        }

        if (n % 3 == 0) {
            int option3 = minimizeN(n / 3, dp);
            res = Math.min(res, option3);
        }

        return dp[n] = res + 1;
    }
}