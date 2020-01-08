class LargestDivisiblePairSubset {
    static int largestSubset(int[] a, int n) {
        // Sort array in increasing order 
        Arrays.sort(a);
    
        // dp[i] is going to store size of largest 
        // divisible subset beginning with a[i]. 
        int[] dp = new int[n];
    
        // Since last element is largest, d[n-1] is 1 
        dp[n - 1] = 1;
    
        // Fill values for smaller elements. 
        for (int i = n - 2; i >= 0; i--) {
    
            // Find all multiples of a[i] and consider 
            // the multiple that has largest subset 
            // beginning with it. 
            int mxm = 0;
            for (int j = i + 1; j<n; j++) {
                if (a[j] % a[i] == 0) {
                    mxm = Math.max(mxm, dp[j]);
                }
            }
    
            dp[i] = 1 + mxm;
        }
    
        // Return maximum value from dp[] 
        return Arrays.stream(dp).max().getAsInt();
    }
}