class CheckSubseqDiv {
    static boolean isSubSeqDivisible(String str) {

        int n = str.length();
        int dp[][] = new int[n + 1][10];
    
        // Converting string to integer array 
        // for ease of computations (Indexing in 
        // arr[] is considered to be starting from 1)
        int arr[] = new int[n + 1];
        for (int i = 1; i<= n; i++)
            arr[i] = (int)(str.charAt(i - 1) - '0');
    
        for (int i = 1; i<= n; i++) {
    
            dp[i][arr[i] % 8] = 1;
            for (int j = 0; j<8; j++) {
    
                // If we consider the number in 
                // our combination, we add it to 
                // the previous combination 
                if (dp[i - 1][j] > dp[i][(j * 10 + arr[i]) % 8])
                    dp[i][(j * 10 + arr[i]) % 8] = dp[i - 1][j];
    
                // If we exclude the number from 
                // our combination 
                if (dp[i - 1][j] > dp[i][j])
                    dp[i][j] = dp[i - 1][j];
            }
        }
    
        for (int i = 1; i<= n; i++) {
    
            // If at dp[i][0], we find value 1/true, 
            // it shows that the number exists at 
            // the value of 'i' 
            if (dp[i][0] == 1)
                return true;
        }
    
        return false;
    }
}
