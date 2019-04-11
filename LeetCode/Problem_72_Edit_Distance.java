class Solution {
    public int minDistance(String word1, String word2) {
        int [][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0;i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return minDistance(word1, word2, 0,0, dp);
    }
    
    public int minDistance(String word1, String word2, int w1, int w2, int[][] dp) {
        if (w1 >= word1.length()) {
            return word2.length() - w2;
        }
        
        if (w2 >= word2.length()) {
            return word1.length() - w1;
        }
        
        if (dp[w1][w2] != -1) {
            return dp[w1][w2];
        }
        
        int char1 = word1.charAt(w1);
        int char2 = word2.charAt(w2);
        
        if (char1 == char2) {
            return dp[w1][w2] = minDistance(word1, word2, w1 + 1, w2 + 1, dp);
        } else {
            int delete = minDistance(word1, word2, w1 + 1, w2, dp);
            int replace = minDistance(word1, word2, w1 + 1, w2 + 1, dp);
            int add = minDistance(word1, word2, w1, w2 + 1, dp);
            
            return dp[w1][w2] = Math.min(delete, Math.min(replace, add)) + 1;
        }
    }
}
