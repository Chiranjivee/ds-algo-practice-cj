class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        int size = s.length() - 1;

        for (int i = size; i >= 0; i--) {
            int x = s.charAt(i) - 'A' + 1;
            int n = (int) Math.pow(26, size - i);
            res += (n * x);
        }
        return res;
    }
}
