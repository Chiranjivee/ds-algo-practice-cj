class Solution {
    public int minDeletionSize(String[] A) {
        if (A.length == 0) {
            return 0;
        }
        
        int cols = A[0].length();
        int count = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = 1; j < A.length; j++) {
                if (A[j].charAt(i) < A[j - 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
}
