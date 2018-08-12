class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.equals("")) {
            return 0; 
        };
        if (s.length() == 1) return 1;

        int n = s.length();
        int [][] m = new int[n][n];

        for (int i = 0; i < n; i++) {
            m[i][i] = 1;
        }

        int td = n - 1;
        int cd = 1;
        while (cd <= td) {
            int cde = n - cd;
            int i = 0; 
            int j = cd;
            while (i < cde) { 
                if (s.charAt(i) != s.charAt(j)) {
                    m[i][j] = Math.max(m[i + 1][j], m[i][j - 1]);
                } else if (j - i - 1 == 0) {
                    m[i][j] = 2;
                } else {
                    m[i][j] = m[i + 1][j - 1] + 2;
                }
                i++; j++;
            }
            cd++;
        }
        
        return m[0][n - 1];
    }
}