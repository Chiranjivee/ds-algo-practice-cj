class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        for (int i = 1; i < words.length; i++) {
            if (!checkTwoWordsAreSorted(words[i - 1], words[i], order)) {
                return false;
            }
        }

        return true;
    }
    
    public boolean checkTwoWordsAreSorted(String word1, String word2, String order) {
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (order.indexOf(word1.charAt(i)) > order.indexOf(word2.charAt(i))) {
                   return false;
                }
                return true;
            }
        }

        if (word1.length() > word2.length()) return false;
        return true;
    }
}
