class Solution {
    public int strongPasswordChecker(String s) {
        if(s.length() < 5) return 6 - s.length();
        if(s.length() == 5) return isAllSameCharacter(s) ? 2 : 1;
        
        int minDeletion = Math.max(0, s.length() - 20);
        int minReplace = calMinReplace(s);
        
        int[] res = new int[] {Integer.MAX_VALUE};
        
        helper(0, 0, 0, minReplace, minDeletion, s, res);
        
        return res[0];
    }
    
    private void helper(int start, int replace, int delete, int minReplace, int minDeletion, String s, int[] res) {
        int next = findNextInvalid(start, s);   

        if(next == s.length()) {
            
            res[0] = Math.min(Math.max(replace, minReplace) + minDeletion, res[0]);
            return;
        }
        // replace is always better than deletion, so when the minDeletion met, we only do replace
        if(delete < minDeletion) {
            // delete
            helper(next - 1, replace, delete + 1, minReplace, minDeletion, s, res);
        }     
        // replace
        helper(next + 1, replace + 1, delete, minReplace, minDeletion, s, res);
    }
    
    private int findNextInvalid(int start, String s) {
        if(start >= s.length()) return s.length();
        
        char c = s.charAt(start);
        
        for(int count = 0, i = start; i < s.length(); i++) {
            if(c == s.charAt(i)) {
                if(++count == 3) return i;
            }  else {
                count = 1;
                c = s.charAt(i);
            }
        }
        
        return s.length();
    }
    
    
    private int calMinReplace(String s) {
        boolean hasUpperCase = false, hasLowerCase = false, hasDigit = false;
        int res = 0;
        for(char c : s.toCharArray()) {
            if(c >= 'A' && c <= 'Z') hasUpperCase = true;
            if(c >= 'a' && c <= 'z') hasLowerCase = true;
            if(c >= '0' && c <= '9') hasDigit = true;
        }
        
        res += hasUpperCase ? 0 : 1;
        res += hasLowerCase ? 0 : 1;
        res += hasDigit ? 0 : 1;
        
        return res;
    }
    
    private boolean isAllSameCharacter(String s) {
        char c = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != c) return false;
        }
        return true;
    }
}
