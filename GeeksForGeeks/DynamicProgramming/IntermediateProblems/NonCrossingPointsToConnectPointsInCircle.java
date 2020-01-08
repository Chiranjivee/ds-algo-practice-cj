class NonCrossingPointsToConnectPointsInCircle {
    static int catalanDP(int n) {
        // Table to store  
        // results of subproblems 
        int[] catalan = new int[n + 1];
    
        // Initialize first 
        // two values in table 
        catalan[0] = catalan[1] = 1;
    
        // Fill entries in catalan[]  
        // using recursive formula 
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++)
                catalan[i] += catalan[j] * catalan[i - j - 1];
        }
    
        // Return last entry 
        return catalan[n];
    }

    static int countWays(int n) {
        // Throw error if n is odd 
        if (n < 1) {
            System.out.println("Invalid");
            return 0;
        }

        return catalanDP(n / 2);
    }
}
