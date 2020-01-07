class FindIfStringIsKPalindrome {
    static int isKPalDP(String str1, String str2, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i<= m; i++) {
            for (int j = 0; j<= n; j++) {

                // If first string is empty, 
                // only option is to remove all 
                // characters of second string 
                if (i == 0) {
                    // Min. operations = j 
                    dp[i][j] = j;
                }

                // If second string is empty,  
                // only option is to remove all 
                // characters of first string 
                else if (j == 0) {
                    // Min. operations = i 
                    dp[i][j] = i;
                }

                // If last characters are same,  
                // ignore last character and 
                // recur for remaining string 
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // If last character are different, 
                //  remove it and find minimum 
                else {
                    // Remove from str1 
                    // Remove from str2 
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    // Returns true if str is k palindrome.
    static boolean isKPal(String str, int k) {
        String revStr = str.reverse();
        int len = str.length();

        return (isKPalDP(str, revStr, len, len) <= k * 2);
    }
}
