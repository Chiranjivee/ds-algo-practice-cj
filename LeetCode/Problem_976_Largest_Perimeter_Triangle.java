class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int res = 0;
        for (int i = A.length - 3; i >= 0; i--) {
            if (canFormTriangle(A[i], A[i + 1], A[i + 2])) {
                return A[i] + A[i + 1] + A[i + 2];
            }
        }
        return res;
    }
    
    public boolean canFormTriangle(int a, int b, int c) {
        return a + b > c && b + c > a && a + c > b;
    }
}
