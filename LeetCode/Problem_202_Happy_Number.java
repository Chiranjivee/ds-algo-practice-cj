import java.util.*;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            n = getSqSumOfDigits(n);
            if (n == 1) return true;
            if (set.contains(n)) break;
            set.add(n);
        }

        return false;
    }
    
    public int getSqSumOfDigits(int n) {
        int sqSum = 0;
        while (n > 0) {
            int digit = n % 10;
            sqSum += (digit * digit);
            n /= 10;
        }
        
        return sqSum;
    }
}
