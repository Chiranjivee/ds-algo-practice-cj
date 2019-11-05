class Solution {
    public int countPrimeSetBits(int L, int R) {
        int [] isPrime = new int[] {
            0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 
            0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1
        };
        
        int count = 0;
        for (int i = L; i <= R; i++) {
            int number = getOneBits(i);
            if (isPrime[number] == 1) {
                count++;
            }
        }
        return count;
    }
    
    public int getOneBits(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) > 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}
