class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len - 1] <= 8) {
            digits[len - 1]++;
            return digits;
        }
        
        // if all 9's
        boolean isAll9s = true;
        for (int i = 0; i < len; i++) {
            if (digits[i] != 9) isAll9s = false;
        }
        
        if (isAll9s) {
            int [] result = new int[len + 1];
            result[0] = 1;
            return result;
        }
        
        int carry = 0;
        digits[len - 1]++;
        if (digits[len - 1] > 9) { 
            digits[len - 1] %= 10;
            carry = 1;
        }
        
        for (int i = len - 2; i >= 0; i--) {
            digits[i] = digits[i] + carry;
            if (digits[i] > 9) { 
                digits[i] %= 10;
                carry = 1;
                continue;
            } 
            break;
        }
        
        return digits;
    }
}
