class Solution {

	static int MAXN = 105; // maximum value of n here  

	// dp[i] = number of max heaps for i distinct integers  
	static int[] dp = new int[MAXN];

	// nck[i][j] = number of ways to choose j elements  
	//         form i elements, no order */  
	static int[][] nck = new int[MAXN][MAXN];

	// log2[i] = floor of logarithm of base 2 of i  
	static int[] log2 = new int[MAXN];

	// to calculate nCk  
	public static int choose(int n, int k) {
		if (k > n) {
			return 0;
		}
		if (n<= 1) {
			return 1;
		}
		if (k == 0) {
			return 1;
		}

		if (nck[n][k] != -1) {
			return nck[n][k];
		}

		int answer = choose(n - 1, k - 1) + choose(n - 1, k);
		nck[n][k] = answer;
		return answer;
	}

	// calculate l for give value of n  
	public static int getLeft(int n) {
		if (n == 1) {
			return 0;
		}

		int h = log2[n];

		// max number of elements that can be present in the  
		// hth level of any heap  
		int numh = (1<< h); //(2 ^ h)  

		// number of elements that are actually present in  
		// last level(hth level)  
		// (2^h - 1)  
		int last = n - ((1<< h) - 1);

		// if more than half-filled  
		if (last >= (numh / 2)) {
			return (1<< h) - 1; // (2^h) - 1  
		} else {
			return (1<< h) - 1 - ((numh / 2) - last);
		}
	}

	// find maximum number of heaps for n  
	public static int numberOfHeaps(int n) {
		if (n<= 1) {
			return 1;
		}

		if (dp[n] != -1) {
			return dp[n];
		}

		int left = getLeft(n);
		int ans = (choose(n - 1, left) * numberOfHeaps(left)) *
			(numberOfHeaps(n - 1 - left));
		dp[n] = ans;
		return ans;
	}

	// function to initialize arrays  
	public static int solve(int n) {
		for (int i = 0; i<= n; i++) {
			dp[i] = -1;
		}

		for (int i = 0; i<= n; i++) {
			for (int j = 0; j<= n; j++) {
				nck[i][j] = -1;
			}
		}

		int currLog2 = -1;
		int currPower2 = 1;

		// for each power of two find logarithm  
		for (int i = 1; i<= n; i++) {
			if (currPower2 == i) {
				currLog2++;
				currPower2 *= 2;
			}
			log2[i] = currLog2;
		}

		return numberOfHeaps(n);
	}

	// Driver code  
	public static void main(String[] args) {
		int n = 10;
		System.out.print(solve(n));
	}
}