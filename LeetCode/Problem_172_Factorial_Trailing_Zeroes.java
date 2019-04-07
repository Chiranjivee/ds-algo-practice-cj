class Solution {
    public int trailingZeroes(int n) {
        int div5 = 0;
        long pow5 = 5;
        
        while (pow5 <= n) {
            div5 += n/pow5;
            pow5 *= 5;
        }
        
        return div5;
    }
}
