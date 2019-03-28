class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            for(int j = i; j <= n; j++){
                dp[j] = Math.max(dp[j], dp[j - i] * i);
            }
        }
        return dp[n];
    }
}
