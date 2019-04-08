class Solution {
    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length()) {
            return false;
        }
        int i = 0; int j = 0;
        
        while (i < s.length()) {
            char currentChar = s.charAt(i);
            boolean lastFound = false;
            for (int k = j; k < t.length(); k++) {
                if (t.charAt(k) == currentChar) {
                    i++;
                    j = k + 1;
                    lastFound = true;
                    break;
                }
            }
            
            if (!lastFound) {
                return false;
            }
        }
        
        return true;
    }
}
