class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;

        if (n % 3 == 0) {
            if (n / 3 == 1)
                return true;
            else
                return isPowerOfThree(n / 3);
        } else if (n == 1)
            return true;
        return false;
    }
}
