class Solution {
    int dp[][] = new int[50][50];

    public int minScoreTriangulation(int[] A) {
        return minScoreTriangulation(A, 0, 0);
    }

    int minScoreTriangulation(int[] A, int i, int j) {
        int res = 0;
        if (j == 0)
            j = A.length - 1;
        if (dp[i][j] != 0)
            return dp[i][j];
        for (int k = i + 1; k < j; ++k) {
            res = Math.min(res == 0 ? Integer.MAX_VALUE : res,
                    minScoreTriangulation(A, i, k) + A[i] * A[k] * A[j] + minScoreTriangulation(A, k, j));
        }
        return dp[i][j] = res;
    }
}
