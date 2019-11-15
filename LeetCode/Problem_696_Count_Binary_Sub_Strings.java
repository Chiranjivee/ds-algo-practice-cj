class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0;
        int curr = 1;
        int pre = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                curr++;
            } else {
                res += Math.min(pre, curr);
                pre = curr;
                curr = 1;
            }
        }
        
        return res + Math.min(pre, curr);
    }
}
