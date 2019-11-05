class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int numOfRows = triangle.size();
        int numCols = triangle.get(numOfRows - 1).size();
        int[] dp = new int[numCols];
        for (int i = 0; i < numCols; i++)
            dp[i] = triangle.get(numOfRows - 1).get(i);

        for (int i = numOfRows - 2; i >= 0; i--) {
            int num = triangle.get(i).size();
            int[] temp = new int[numCols];
            List<Integer> current = triangle.get(i);

            for (int j = 0; j < num; j++)
                temp[j] = Math.min(dp[j], dp[j + 1]) + current.get(j);
            dp = temp;
        }

        return dp[0];
    }
}
