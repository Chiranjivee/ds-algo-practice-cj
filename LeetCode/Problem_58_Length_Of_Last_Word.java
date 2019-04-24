class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.equals("")) return 0;

        int lastSpace = s.lastIndexOf(" ");
        if (lastSpace < 0) return s.length();
        return s.length() - lastSpace - 1;
    }
}
