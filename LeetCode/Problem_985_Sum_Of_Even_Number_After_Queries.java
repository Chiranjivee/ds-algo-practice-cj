class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int evenSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                evenSum += A[i];
            }
        }

        int[] res = new int[A.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][1];
            int val = queries[i][0];
            int oldVal = A[idx];
            res[i] = evenSum;
            A[idx] += val;
            if (oldVal % 2 == 0) {
                evenSum -= oldVal;
                res[i] = evenSum;
            }

            if (A[idx] % 2 == 0) {
                evenSum += A[idx];
                res[i] = evenSum;
            }
        }
        return res;
    }
}
