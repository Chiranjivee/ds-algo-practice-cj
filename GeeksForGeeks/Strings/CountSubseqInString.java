class Solution {
    static int count(String a, String b) {
        int m = a.length();
        int n = b.length();

        int lookup[][] = new int[m + 1][n + 1];
    
        // If first string is empty 
        for (int i = 0; i<= n; ++i)
            lookup[0][i] = 0;
    
        // If second string is empty 
        for (int i = 0; i<= m; ++i)
            lookup[i][0] = 1;
    
        // Fill lookup[][] in  
        // bottom up manner 
        for (int i = 1; i<= m; i++) {
            for (int j = 1; j<= n; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1] + lookup[i - 1][j];
    
                else
                    // If last character are  
                    // different, ignore last 
                    // character of first string 
                    lookup[i][j] = lookup[i - 1][j];
            }
        }
    
        return lookup[m][n];
    }
}
