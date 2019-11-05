class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String [] morse = new String[] {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                builder.append(morse[word.charAt(i) - 'a']);
            }

            set.add(builder.toString());
        }
        return set.size();
    }
}
