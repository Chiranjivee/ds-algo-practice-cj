class Solution {
    public boolean isPowerOfThree(int n) {
        if (n<=0) return false;
        if (n == 1) return true;
        if (n % 3 == 0) return isPowerOfThree(n/3);    
        return false;
    }

    public boolean isPowerOfThreeInConstantTime(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        // Basically modding with max power of 3 gives 0 for every power of 3
        return (n > 0 && 1162261467 % n == 0);
    }
}
