class NumberOfNDigitSteppingNumber {
    static long answer(int n) {
        // dp[i][j] stores count of i  
        // digit stepping numbers ending  
        // with digit j. 
        int dp[][] = new int[n + 1][10];
    
        // if n is 1 then answer will be 10. 
        if (n == 1)
            return 10;
    
        // Initialize values for count of 
        // digits equal to 1. 
        for (int j = 0; j<= 9; j++)
            dp[1][j] = 1;
    
        // Compute values for count of  
        // digits more than 1. 
        for (int i = 2; i<= n; i++) {
            for (int j = 0; j<= 9; j++) {
    
                // If ending digit is 0 
                if (j == 0)
                    dp[i][j] = dp[i - 1][j + 1];
    
                // If ending digit is 9 
                else if (j == 9)
                    dp[i][j] = dp[i - 1][j - 1];
    
                // For other digits. 
                else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
            }
        }
    
        // stores the final answer 
        long sum = 0;
        for (int j = 1; j<= 9; j++)
            sum += dp[n][j];
        return sum;
    }
}
