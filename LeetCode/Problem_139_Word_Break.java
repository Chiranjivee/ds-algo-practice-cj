class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int [] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return wordBreakUtil(s, 0, wordDict, dp) > 0;
    }
    
    public int wordBreakUtil(String s, int start, List<String> wordDict, int [] dp) {
        if (start == s.length()) {
            return 1;
        }
        
        if (dp[start] != -1) {
            return dp[start];
        }

        int result = 0;
        for (int i = start; i <= s.length(); i++) {
            String current = s.substring(start, i);
            System.out.println(current);
            if (wordDict.contains(current)) {
                result += wordBreakUtil(s, i, wordDict, dp);
            }
            
            if (result > 0) {
                return dp[start] = result;
            }
        }
        
        return dp[start] = result;
    }
}
