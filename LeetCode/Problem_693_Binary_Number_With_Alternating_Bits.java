class Solution {
    public boolean hasAlternatingBits(int n) {
        int current = n & 1;
        int next = current ^ 1;
        n >>= 1;
        while (n != 0) {
            if (next != (n & 1)) {
                return false;
            } else {
                next = next ^ 1;
                n >>= 1;
            }
        }
        
        return true;
    }
}
