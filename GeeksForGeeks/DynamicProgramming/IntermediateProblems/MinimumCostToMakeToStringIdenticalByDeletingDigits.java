class MinCostToMakeStringIdentical {
	static int lcs(char[] X, char[] Y, int m, int n) {
		int[][] L = new int[m + 1][n + 1];

		/* Following steps build L[m+1][n+1] in  
		bottom up fashion. Note that L[i][j] contains  
		cost of removing identical characters in  
		LCS of X[0..i-1] and Y[0..j-1] */
		for (int i = 0; i<= m; ++i) {
			for (int j = 0; j<= n; j++) {

				if (i == 0 || j == 0)
					L[i][j] = 0;

				// If both characters are same,  
				// add both of them 
				else if (X[i - 1] == Y[j - 1]) {
					L[i][j] = L[i - 1][j - 1] + 2 * (X[i - 1] - '0');
				}

				// Otherwise find the maximum  
				// cost among them 
				else
					L[i][j] = L[i - 1][j] > L[i][j - 1] ?
					L[i - 1][j] : L[i][j - 1];
			}
		}

		System.out.println("LCS: " + L[m][n]);
		return L[m][n];
	}

	// Returns cost of making X[] and Y[] identical 
	static int findMinCost(char X[], char Y[]) {
		// Find LCS of X[] and Y[] 
		int m = X.length, n = Y.length;

		// Initialize the cost variable 
		int cost = 0;

		// Find cost of all characters in 
		// both strings 
		for (int i = 0; i<m; ++i)
			cost += X[i] - '0';

		for (int i = 0; i<n; ++i)
			cost += Y[i] - '0';

		System.out.println("Cost: " + cost);
		return cost - lcs(X, Y, m, n);
	}

	public static void main(String[] args) {

		System.out.println(findMinCost("9350".toCharArray(), "3759".toCharArray()));
	}
}
