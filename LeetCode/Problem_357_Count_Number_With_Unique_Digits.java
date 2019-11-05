class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0 || n == 1) return 10 * n;
        int nineProd = 9;
        int result = 10;
        int run = 9;
        for (int i = 2; i <= n; i++) {
            int temp = nineProd * run--;
            result += (temp);
            nineProd = temp;   
        }
        return result;
    }
}
