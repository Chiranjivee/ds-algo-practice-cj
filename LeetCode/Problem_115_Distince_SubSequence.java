class Solution {
    public int numDistinct(String s, String t) {
        int [][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return numDistinct(s, t, -1, 0, dp);
    }

    public int numDistinct(String s, String t, int sIdx, int tIdx, int [][] dp) {
        if (sIdx == s.length()) {
            return 0;
        }

        if (tIdx == t.length()) {
            return 1;
        }
        
        if (sIdx != -1 && dp[sIdx][tIdx] != -1) {
            return dp[sIdx][tIdx];
        }
        
        char current = t.charAt(tIdx);
        List<Integer> idxs = new ArrayList<>();
        for (int i = sIdx + 1; i < s.length(); i++) {
            if (current == s.charAt(i)) {
                idxs.add(i);
            }
        }
        
        int option = 0;
        for (Integer i : idxs) {
            option += numDistinct(s, t, i, tIdx + 1, dp);
        }
        
        if (sIdx == -1) {
            return option;
        }

        return dp[sIdx][tIdx] = option;        
    }
}
