class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] ransom = new int[26];
        for (Character c : ransomNote.toCharArray()) {
            int index = c - 'a';
            ransom[index]++;
        }
        
        for (Character c : magazine.toCharArray()) {
            int index = c - 'a';
            ransom[index]--;
        }
        
        for (int i = 0; i < ransom.length; i++) {
            if (ransom[i] > 0) return false;
        }
        return true;
    }
}
