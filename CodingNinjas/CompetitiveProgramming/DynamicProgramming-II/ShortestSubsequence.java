
public class ShortestSubsequence {
	static int MAX = 1000000000;
	public int solve(String S,String V){
      	 int m = S.length();
      	 int n = V.length();
            int [][] dp = new int[m + 1][n + 1];
         int ans = solveUtil(S,V,0,0, dp);
         if (ans == m) {
             return MAX;
         }
         return ans;
	}
    
    public int solveUtil(String s, String v, int sIdx, int vIdx, int [][] dp) {
        if (vIdx >= v.length()) {
            return 1;
        }
        
        if (sIdx == s.length()) {
            return MAX;
        }
        
        if (dp[sIdx][vIdx] != 0) {
            return dp[sIdx][vIdx];
        }
        
        int optionOne = solveUtil(s, v, sIdx + 1, vIdx, dp);
        int c = s.charAt(sIdx);
        int newVIdx = v.indexOf(c, vIdx);
        if (newVIdx < 0) return 1;
        
        int optionTwo = 1 + solveUtil(s, v, sIdx + 1, newVIdx + 1, dp);
        return dp[sIdx][vIdx] = Math.min(optionOne, optionTwo);
    }
}
