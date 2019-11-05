class Solution {
    public int countCharacters(String[] words, String chars) {
        int [] available = new int [26];
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            available[c - 'a']++;
        }
        
        int result = 0;
        for (String word : words) {
            if (couldBeMadeFromAvailableChars(word, Arrays.copyOf(available, available.length))) {
                result += word.length();
            }
        }
        
        return result;
    }
    
    public boolean couldBeMadeFromAvailableChars(String word, int [] available) {
        for (int i = 0; i < word.length(); i++) {
            if (available[word.charAt(i) - 'a'] == 0) {
                return false;
            } else {
                available[word.charAt(i) - 'a']--;
            }
        }

        return true;
    }
}
