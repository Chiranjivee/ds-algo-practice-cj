class Solution {
    public boolean checkRecord(String s) {
        return !(s.indexOf("LLL") >= 0 || s.indexOf("A") >= 0 && s.indexOf("A", s.indexOf("A") + 1) >= 0);
    }
}
