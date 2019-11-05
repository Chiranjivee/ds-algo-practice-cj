class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int [] dp = new int[pairs.length];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < pairs.length; i++) {
            int last = pairs[i][0];
            for (int j = 0; j < i; j++) {
                if (last > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return Math.max(1, max);
    }
}
