class Solution {
    public int nthUglyNumber(int n) {
        int [] ugly = new int[n];
        ugly[0] = 1;
        int idxOf2 = 0, idxOf3 = 0, idxOf5 = 0;
        int factOf2 = 2, factOf3 = 3, factOf5 = 5;
        
        for (int i = 1; i < n; i++) {
            int min = Math.min(factOf2, Math.min(factOf3, factOf5));
            ugly[i] = min;
            if (factOf2 == min) factOf2 = 2 * ugly[++idxOf2];
            if (factOf3 == min) factOf3 = 3 * ugly[++idxOf3];
            if (factOf5 == min) factOf5 = 5 * ugly[++idxOf5];
        }
        
        return ugly[n - 1];
    }
}
