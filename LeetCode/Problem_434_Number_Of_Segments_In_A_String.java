class Solution {
    public int countSegments(String s) {
        if (s == null || s.trim().equals("")) return 0;
        return s.trim().split("\\s+").length;
    }

    public int countSegmentsWayTwo(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }
        return count;
    }
}
