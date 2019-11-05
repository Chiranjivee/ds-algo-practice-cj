class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length == 0) {
            return false;
        }

        if (A.length == 1) {
            return true;
        }

        int isIncreasing = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] > A[i]) {
                isIncreasing = 0;
                break;
            }
        }
        
        int isDecreasing = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                isDecreasing = 0;
                break;
            }
        }
        
        return isIncreasing == 1 || isDecreasing == 1;
    }
}
