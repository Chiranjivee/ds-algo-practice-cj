class Solution {
    public int countLetters(String S) {
        int res = 0, j = 0;
        char curr = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == curr) {
                j++;
            } else {
                curr = S.charAt(i);
                j = 1;
            }

            res += j;
        }
        return res;
    }
}
