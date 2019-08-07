class Solution {
    public int digitsCount( int d, int low, int high ) {
        if (d < 0 || high < 0 ) {
            return 0;
        }

        return countDigit(high, d) - countDigit(low - 1, d);
    }
    
    private int countDigit(int value, int digit) {
        int count = 0;
        for (int pow10 = 1; pow10 <= value; pow10 *= 10) {
            int divisor = pow10 * 10;

            int quotient = value / divisor;
            if( quotient > 0 ) {
                count += quotient * pow10;                
            }

            if(digit == 0) {
                count -= pow10;
            }
            
            int remainder = value % divisor;
            if (remainder >= digit * pow10) {
                count += Math.min(remainder - digit * pow10 + 1, pow10);
            }
        }

        return count;
    }
}
