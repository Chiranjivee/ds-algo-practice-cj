class Solution {
    public String toGoatLatin(String S) {
        String [] parts = S.split(" ");
        StringBuilder a = new StringBuilder("a");
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= parts.length; i++) {
            int idx = i - 1;
            if (isVowel(parts[idx].charAt(0))) {
                result.append(parts[idx]);
            } else {
                result.append(parts[idx].substring(1) + parts[idx].charAt(0));    
            }

            result.append("ma");
            result.append(a);
            a.append("a");
            result.append(' ');
        }

        result.setLength(result.length() - 1);
        return result.toString();
    }
    
    private boolean isVowel(char c) {
        String vowel = "aeiouAEIOU";
        return vowel.indexOf(c) >= 0;
    }
}
