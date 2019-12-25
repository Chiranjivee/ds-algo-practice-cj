class CountBST {
    public int getCount(int h) {
        if (h == 0 || h == 1) {
            return 1;
        }

        return 2 * count(h - 2) * count(h - 1) + count(h - 1) * count(h - 1);
    }

    public int getCountDP(int h) {
        int [] dp = new int[h + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= h; i++) {
            dp[i] = 2 * dp[i - 2] * dp[i - 1] + dp[i - 1] * dp[i - 1];
        }

        return dp[h];
    }
}
