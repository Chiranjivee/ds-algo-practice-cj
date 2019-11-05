class Solution {
    public String removeVowels(String S) {
        Set<Character> set = getVowelSet();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (!set.contains(S.charAt(i))) {
                result.append(S.charAt(i));
            }
        }
        return result.toString();
    }
    
    private Set<Character> getVowelSet() {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        return set;
    }
}
