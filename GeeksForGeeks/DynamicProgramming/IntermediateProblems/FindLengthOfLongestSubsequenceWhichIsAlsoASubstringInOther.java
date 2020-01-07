public class FindLongestSubsequenceWhichIsAlsoSubstring {
	static final int MAX = 1000;

	// Return the maximum size of substring of 
	// X which is substring in Y. 
	static int maxSubsequenceSubstring(char x[], char y[],
		int n, int m) {
		int dp[][] = new int[MAX][MAX];

		// Initialize the dp[][] to 0. 
		for (int i = 0; i<= m; i++)
			for (int j = 0; j<= n; j++)
				dp[i][j] = 0;

		// Calculating value for each element. 
		for (int i = 1; i<= m; i++) {
			for (int j = 1; j<= n; j++) {

				// If alphabet of string X and Y are 
				// equal make dp[i][j] = 1 + dp[i-1][j-1] 
				if (x[j - 1] == y[i - 1])
					dp[i][j] = 1 + dp[i - 1][j - 1];

				// Else copy the previous value in the 
				// row i.e dp[i-1][j-1] 
				else
					dp[i][j] = dp[i][j - 1];
			}
		}

		// Finding the maximum length. 
		int ans = 0;
		for (int i = 1; i<= m; i++)
			ans = Math.max(ans, dp[i][n]);

		return ans;
	}

	// Driver Method 
	public static void main(String[] args) {
		char x[] = "ABCD".toCharArray();
		char y[] = "BACDBDCD".toCharArray();
		int n = x.length, m = y.length;
		System.out.println(maxSubsequenceSubstring(x, y, n, m));
	}
}
