class Solution {
    public int[] sortedSquares(int[] A) {
        int left = 0;
        int right = A.length - 1;

        int [] res = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            int left2 = A[left] * A[left];
            int right2 = A[right] * A[right];
            res[i] = Math.max(left2, right2);
            if (left2 > right2) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
