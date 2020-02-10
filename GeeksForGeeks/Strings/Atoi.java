class Solution {
    public int myAtoi(String str) {
        State st = State.START;
        int number = 0;
        int sign = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (st == State.START && c == ' ') {
                continue;
            }
            
            if (st == State.START && c == '-') {
                sign = 1;
                st = State.DIGIT;
                continue;
            }

            if (st == State.START && c == '+') {
                sign = 0;
                st = State.DIGIT;
                continue;
            }
            
            if (st == State.START && Character.isDigit(c)) {
                number = c - '0';
                st = State.DIGIT;
                continue;
            }
            
            if (st == State.START && !Character.isDigit(c)) {
                return 0;
            }
            
            if (st == State.DIGIT && Character.isDigit(c)) {
                int digit = c - '0';
                if (number > Integer.MAX_VALUE / 10) {
                    return handleOverflowWithSign(sign);        
                }
                
                number *= 10;
                if (number + digit < 0) {
                    return handleOverflowWithSign(sign);
                }
                
                number += digit;
                continue;
            }

            if (st == State.DIGIT && !Character.isDigit(c)) {
                return getResultWithSign(number, sign);
            }
        }

        return getResultWithSign(number, sign);
    }
    
    public int getResultWithSign(int number, int sign) {
        if (sign == 1) {
            return -1 * number;
        } else {
            return number;
        }
    }
    
    public int handleOverflowWithSign(int sign) {
        if (sign == 1) {
            return Integer.MIN_VALUE;
        } else { 
            return Integer.MAX_VALUE;
        }
    }
}

enum State {
    START,
    DIGIT
}
