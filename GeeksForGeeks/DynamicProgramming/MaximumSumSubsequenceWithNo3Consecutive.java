class MaximumSumSubsequence {
    public int maxSumSubsequenceWithNoThreeConsecutiveElements(int [] arr) {

        int [] dp = new int[arr.length];

        // dp[i] means, max sum ending at idx i
        if (arr.length == 1) dp[0] = arr[0];
        if (arr.length == 2) dp[1] = arr[0] + arr[1];

        if (arr.length == 3) {
            dp[2] = Math.max(
                dp[1],  // i.e. don't consider the current element
                Math.max(
                    arr[1] + arr[2], // don't consider the idx 0 element
                    arr[0] + arr[2])) // don't consider the idx 1 element
        }

        for (int i = 3; i < arr.length; i++) {
            dp[i] = 
                Math.max(dp[i - 1], // don't consider the current element
                    Math.max(
                        dp[i - 2] + arr[i],
                        dp[i - 3] + arr[i] + arr[i - 1]
                    )
                );
        }
    }

    static int dp[] = new int[1000];
    public int maxSubseqSumRecursive(int [] arr, int n) {
        if (n == 0) {
            return dp[n] = 0;
        }

        if (n == 1) {
            return dp[n] = arr[0];
        }

        if (n == 2) {
            return dp[n] = arr[0] + arr[1];
        }

        return 
            Math.max(
                maxSubseqSumRecursive(arr, n - 1), // max sub seq sum without this element
                Math.max(
                    arr[n - 1] + maxSubseqSumRecursive(n - 2); // consider this element but don't consider the element before this
                    arr[n - 1] + arr[n - 2] + maxSubseqSumRecursive(n - 3)));
    }



    static int maxSumWO3Consec(int n)  
{  
    if(sum[n] != -1)  
        return sum[n];  
      
    //Base cases (process first three elements)  
      
    if(n == 0)  
        return sum[n] = 0;  
      
    if(n == 1)  
        return sum[n] = arr[0];  
      
    if(n == 2)  
        return sum[n] = arr[1] + arr[0];  
      
    // Process rest of the elements  
    // We have three cases  
    return sum[n] = Math.max(Math.max(maxSumWO3Consec(n - 1),  
                    maxSumWO3Consec(n - 2) + arr[n - 1]),  
                    arr[n - 2] + arr[n - 1] + maxSumWO3Consec(n - 3));  
      
      
}  

}