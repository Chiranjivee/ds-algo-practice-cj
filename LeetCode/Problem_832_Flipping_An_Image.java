class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int left = 0;
            int right = A.length - 1;
            
            while (left <= right) {
                int temp = A[i][left];
                A[i][left] = A[i][right];
                A[i][right] = temp;
                
                A[i][left] ^= 1;
                A[i][right] ^= 1;
                if (left == right) A[i][right] ^= 1;
                left++; right--;
            }
        }

        return A;
    }
}
