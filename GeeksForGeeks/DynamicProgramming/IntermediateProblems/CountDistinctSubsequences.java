class CountDistinctSubsequences {
    public int countDistinctSubsequences(String str) {

        // stores the last index of this char encountered
        int [] last = new int [256];

        Arrays.fill(last, -1);

        int [] dp = new int[n + 1];

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 2 * dp[i - 1];

            int currentCharIdx = str.charAt(i - 1);
            if (last[currentCharIdx] != -1) {
                dp[i] = dp[i] - dp[last[currentCharIdx]];
            }

            last[currentCharIdx] = i - 1;
        }
    }
}
