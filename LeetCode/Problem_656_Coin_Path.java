public class Solution {
    public List < Integer > cheapestJump(int[] A, int B) {
        int[] next = new int[A.length];
        Arrays.fill(next, -1);
        long[] memo = new long[A.length];
        jump(A, B, 0, next, memo);
        List < Integer > res = new ArrayList();
        int i;
        for (i = 0; i < A.length && next[i] > 0; i = next[i])
            res.add(i + 1);
        if (i == A.length - 1 && A[i] >= 0)
            res.add(A.length);
        else
            return new ArrayList < Integer > ();
        return res;
    }
    public long jump(int[] A, int B, int i, int[] next, long[] memo) {
        if (memo[i] > 0)
            return memo[i];
        if (i == A.length - 1 && A[i] >= 0)
            return A[i];
        long min_cost = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + B && j < A.length; j++) {
            if (A[j] >= 0) {
                long cost = A[i] + jump(A, B, j, next, memo);
                if (cost < min_cost) {
                    min_cost = cost;
                    next[i] = j;
                }
            }
        }
        memo[i] = min_cost;
        return min_cost;
    }
}
