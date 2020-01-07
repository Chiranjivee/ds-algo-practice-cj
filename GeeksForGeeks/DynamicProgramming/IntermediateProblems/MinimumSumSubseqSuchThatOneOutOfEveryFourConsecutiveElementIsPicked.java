class MinSumSubSeqWithOneOutOfEveryFour {
    static int minSum(int[] arr, int n) 
    { 
        // dp[i] is going to store minimum sum 
        // subsequence of arr[0..i] such that arr[i] 
        // is part of the solution. Note that this 
        // may not be the best solution for subarray 
        // arr[0..i] 
        int[] dp = new int[n]; 
  
        // If there is single value, we get the 
        // minimum sum equal to arr[0] 
        if (n == 1) 
            return arr[0]; 
  
        // If there are two values, we get the 
        // minimum sum equal to the minimum of 
        // two values 
        if (n == 2) 
            return Math.min(arr[0], arr[1]); 
  
        // If there are three values, return 
        // minimum of the three elements of 
        // array 
        if (n == 3) 
        return Math.min(arr[0], Math.min(arr[1], arr[2])); 
  
        // If there are four values, return minimum 
        // of the four elements of array 
        if (n == 4) 
            return Math.min(Math.min(arr[0], arr[1]), Math.min(arr[2], arr[3]));
  
        dp[0] = arr[0]; 
        dp[1] = arr[1]; 
        dp[2] = arr[2]; 
        dp[3] = arr[3]; 
  
        for (int i = 4; i < n; i++) 
            dp[i] = arr[i] + Math.min(Math.min(dp[i - 1], dp[i - 2]), Math.min(dp[i - 3], dp[i - 4])); 
  
        // Return the minimum of last 4 index 
        return Math.min(Math.min(dp[n - 1], dp[n - 2]), Math.min(dp[n - 4], dp[n - 3])); 
    }
}
