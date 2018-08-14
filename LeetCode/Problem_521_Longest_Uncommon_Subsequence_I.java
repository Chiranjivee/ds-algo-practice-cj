class Solution{
    public int longestUncommonSubsequence(String a, String b) {
        if (a.equals(b)) return -1;
        return Math.max(a.length(), b.length());
    }
}