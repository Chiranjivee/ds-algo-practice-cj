class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isGoodNumber(i)) {
                System.out.println(i);
                count++;
            }
        }

        return count;
    }
    
    private boolean isGoodNumber(int n) {
        boolean isValid = false;
        while (n != 0) {
            int currDigit = n % 10;
            if (currDigit == 3 || currDigit == 4 || currDigit == 7) {
                return false;
            }
            
            if (currDigit == 2) isValid = true;
            else if (currDigit == 5) isValid = true;
            else if (currDigit == 6) isValid = true;
            else if (currDigit == 9) isValid = true;
            n = n / 10;
        }
        
        return isValid;
    }
}
