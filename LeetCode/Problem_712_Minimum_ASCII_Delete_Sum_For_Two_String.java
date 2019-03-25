class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        if (s1.equals(s2)) {
            return 0;
        }
        
        int [][] dp = new int[s1.length()][s2.length()];
        
        return minDeleteSum(s1, s2, s1.length() - 1, s2.length() - 1, dp);
    }
    
    public int minDeleteSum(String s1, String s2, int sIdx, int s2Idx, int [][] dp) {
        if (sIdx < 0) {
            int temp = 0;
            for (int i = 0; i <= s2Idx; i++) temp += s2.charAt(i);
            return temp;
        } 
        
        if (s2Idx < 0) {
            int temp = 0;
            for (int i = 0; i <= sIdx; i++) temp += s1.charAt(i);
            return temp;
        }
        
        if (dp[sIdx][s2Idx] != 0) {
            return dp[sIdx][s2Idx];
        }
        
        String sOne = s1.substring(0, sIdx + 1);
        String sTwo = s2.substring(0, s2Idx + 1);
        
        if (sOne.equals(sTwo)) {
            return dp[sIdx][s2Idx] = 0;
        }
            
        if (s1.charAt(sIdx) == s2.charAt(s2Idx)) {
            return dp[sIdx][s2Idx] = minDeleteSum(s1, s2, sIdx -1, s2Idx - 1, dp);
        }

        int optionOne = s1.charAt(sIdx) + minDeleteSum(s1, s2, sIdx - 1, s2Idx, dp);
        int optionTwo = s2.charAt(s2Idx) + minDeleteSum(s1, s2, sIdx, s2Idx - 1, dp);
        
        return dp[sIdx][s2Idx] = Math.min(optionOne, optionTwo);
    }
}
