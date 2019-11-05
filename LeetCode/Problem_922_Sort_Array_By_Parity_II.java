class Solution {
    public int[] sortArrayByParityII(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0 && A[i] % 2 != 0) {
                int j = i + 1;
                while (A[j] % 2 != 0) j++;
                swap(A, i, j);
            } else if (A[i] % 2 == 0 && i % 2 != 0) {
                int j = i + 1;
                while (A[j] % 2 == 0) j++;
                swap(A, i, j);
            }
        }
        
        return A;
    }
    
    public void swap(int [] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
