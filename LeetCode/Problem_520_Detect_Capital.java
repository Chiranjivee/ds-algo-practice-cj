class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.equals("")) {
            return false;
        }
        
        boolean allCapitals = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                continue;
            } else {
                allCapitals = false;
                break;
            }
        }
        
        if (allCapitals) return true;
        
        
        boolean allSmall = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                continue;
            } else {
                allSmall = false;
                break;
            }
        }

        if (allSmall) return true;
        
        boolean isOnlyFirstCapital = true;
        for (int i = 0; i < word.length(); i++) {            
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z' && i != 0) {
                isOnlyFirstCapital = false;
                break;
            } else {
                continue;
            }
        }
        
        if (isOnlyFirstCapital) return true;
        return false;
    }
}
