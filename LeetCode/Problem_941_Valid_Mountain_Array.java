class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        
        int i = 0;
        int j = A.length - 1;
        
        while (i < A.length - 2 && A[i] < A[i + 1]) i++;
        while (j > 1 && A[j - 1] > A[j]) j--;

        return i == j;
    }
}
