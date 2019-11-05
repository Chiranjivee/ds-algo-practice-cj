class Solution {
    public int calculateMinimumHP(int[][] mat) {
        int[][] dp = new int[mat.length][mat[0].length];
        int row = mat.length - 1;
        int col = mat[0].length - 1;
		dp[mat.length - 1][mat[0].length - 1] = mat[row][col] > 0 ? 1 : -mat[row][col] +  1;
		for (int r = mat.length - 1; r >= 0; r--) {
			for (int i = mat[0].length - 1; i >= 0; i--) {
				if (i == mat[0].length - 1 && r == mat.length - 1) {
					continue;
				}
				int optionOne = r == mat.length - 1 ? Integer.MAX_VALUE : dp[r + 1][i];
				int optionTwo = i == mat[0].length - 1 ? Integer.MAX_VALUE : dp[r][i + 1];
				int ans = Math.min(optionOne, optionTwo);
				int current = mat[r][i];
				dp[r][i] = (current >= ans) ? 1 : ans - current;
			}
		}

		return dp[0][0];
    }
}
