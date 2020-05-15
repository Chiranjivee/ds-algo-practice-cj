class Solution {
    public int findComplement(int num) {
        int n = num;
        int bit = 1;
        
        while (n != 0) {
            num ^= bit;
            bit <<= 1;
            n >>= 1;
        }
        
        return num;
    }
}
