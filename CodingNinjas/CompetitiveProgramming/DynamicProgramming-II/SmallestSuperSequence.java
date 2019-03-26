public class SmallestSuperSequence {
	public static int smallestSuperSequence(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = n; i >= 0; i--) {
			dp[m][i] = n - i;
		}

		for (int i = m; i >= 0; i--) {
			dp[i][n] = m - i;
		}

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = 1 + dp[i + 1][j + 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		return dp[0][0];
	}
}
