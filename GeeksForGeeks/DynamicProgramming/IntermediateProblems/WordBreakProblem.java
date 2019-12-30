class WordBreakProblem {
    public boolean wordBreakDP(String str, String [] dict) {
        int [] dp = new int[str.length];
        Arrays.fill(dp, -1);
        return wordBreak(str, dict, 0, dp);
    }

    public boolean wordBreak(String str, String [] dict, int start, int [] dp) {

        if (str.length() == start + 1) {
            return dp[start] = 1;
        }

        if (dp[start] != -1) {
            return dp[start];
        }

        for (int i = start + 1; i <= str.length(); i++) {
            String prefix = str.substring(start, i);
            if (dict.contains(prefix) && wordBreak(str, dict, i) == 1) {
                return dp[start] = 1;
            }
        }

        return dp[start] = 0;
    }
}
