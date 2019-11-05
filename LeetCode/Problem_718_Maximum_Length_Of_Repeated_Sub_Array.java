class Solution {
    public int findLength(int[] A, int[] B) {
        if(A == null || B == null) return 0;
        int m = A.length;
        int n = B.length;
        int max = 0;
        //dp[i][j] is the length of longest common subarray ending with nums[i] and nums[j]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                if(A[i - 1] == B[j - 1]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }
}
