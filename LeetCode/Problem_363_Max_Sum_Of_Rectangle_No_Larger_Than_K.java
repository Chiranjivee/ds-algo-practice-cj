class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            int[] sum = new int[m];
            for (int j = i; j < n; ++j) {
                for (int r = 0; r < m; ++r) {
                    sum[r] += matrix[r][j];
                }
                int curSum = 0;
                TreeSet<Integer> map = new TreeSet<>();
                map.add(0);
                for (int r = 0; r < m; ++r) {
                    curSum += sum[r];
                    Integer it = map.ceiling(curSum - k);
                    if (it != null) {
                        max = Math.max(max, curSum - it);
                    }
                    map.add(curSum);
                }
            }
        }
        return max;
    }
}
