class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = A[0];
        int max = A[0];
        
        for (Integer e: A) {
            min = Math.min(min, e);
            max = Math.max(max, e);
        }
        
        return Math.max(0, max - min - 2 * K);
    }
}
