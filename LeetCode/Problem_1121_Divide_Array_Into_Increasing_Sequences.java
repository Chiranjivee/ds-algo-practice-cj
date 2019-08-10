class Solution {
    public boolean canDivideIntoSubsequences(int[] A, int K) {
        int cur = 1, groups = 1, n = A.length;
        for (int i = 1; i < n; ++i) {
            cur = A[i - 1] < A[i] ?  1 : cur + 1;
            groups = Math.max(groups, cur);
        }
        return n >= K * groups;
    }
}
