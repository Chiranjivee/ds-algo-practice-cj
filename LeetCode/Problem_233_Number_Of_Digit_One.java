class Solution {
    public int countDigitOne(int n) {
        if (n < 0) {
            return 0;
        }
        String x = String.valueOf(n);
        int result = 0;
        long divisor = 10;
        for (int i = 1; i <= x.length(); i++) {
            if (i == 1) {
                result += ((n / 10) + (n % 10 != 0 ? 1 : 0)); 
            } else {
                int firstPart = (int)(n / divisor) * (int) (divisor / 10);
                int secondPart = (int) Math.min(Math.max(n % divisor - (divisor / 10) + 1, 0), divisor / 10);
                result += firstPart + secondPart;
            }

            divisor *= 10;
        }
        return result;
    }
}
