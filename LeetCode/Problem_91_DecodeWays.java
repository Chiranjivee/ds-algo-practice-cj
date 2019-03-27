import java.util.Arrays;

class Solution { 
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int [] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return numDecodings(s, 0, dp);
    }
    
    public int numDecodings(String s, int idx, int [] dp) {
        if (idx > s.length()) {
            return 0;
        }
        if (s.length() == idx) {
            return dp[idx] = 1;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        
        int optionOne = 0;
        if (Character.getNumericValue(s.charAt(idx)) != 0) {
            optionOne = numDecodings(s, idx + 1, dp);
        }
        
        int optionTwo = 0;
        if (idx + 1 < s.length()) {
            int tens = Character.getNumericValue(s.charAt(idx)) * 10;
            int ones = Character.getNumericValue(s.charAt(idx + 1));
            if (tens > 0) {
                int number = tens + ones;
                if (number > 0 && number < 27) {
                    optionTwo = numDecodings(s, idx + 2, dp);
                }    
            }
            
        }
        return  dp[idx] = optionOne + optionTwo;
    }
}
