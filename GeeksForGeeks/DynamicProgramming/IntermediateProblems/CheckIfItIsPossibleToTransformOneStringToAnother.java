class CheckTransformPossible {
    static boolean check(String s1, String s2) {
        // calculates length 
        int n = s1.length();
        int m = s2.length();
    
        boolean dp[][] = new boolean[n + 1][m + 1];

        // mark 1st position as true 
        dp[0][0] = true;
    
        // traverese for all DPi, j 
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j<= s2.length(); j++) {
    
                // if possible for to convert i  
                // characters of s1 to j characters 
                // of s2 
                if (dp[i][j]) {
    
                    // if upper_case(s1[i])==s2[j] 
                    // is same 
                    if (j < s2.length() && (Character.toUpperCase(s1.charAt(i)) == s2.charAt(j)))
                        dp[i + 1][j + 1] = true;
    
                    // if not upper then deletion is  
                    // possible 
                    if (!Character.isUpperCase(s1.charAt(i)))
                        dp[i + 1][j] = true;
                }
            }
        }
    
        return (dp[n][m]);
    }
}
