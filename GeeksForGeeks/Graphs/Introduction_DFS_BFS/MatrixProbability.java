class MatrixProbability {

	static boolean isSafe(int x, int y,
		int m, int n) {
		return (x >= 0 && x<m &&
			y >= 0 && y<n);
	}

	static double findProbability(int m, int n,
		int x, int y,
		int N) {

		// boundary crossed 
		if (!isSafe(x, y, m, n))
			return 0.0;

		// N steps taken 
		if (N == 0)
			return 1.0;

		// Initialize result 
		double prob = 0.0;

		// move up 
		prob += findProbability(m, n, x - 1,
			y, N - 1) * 0.25;

		// move right 
		prob += findProbability(m, n, x, y + 1,
			N - 1) * 0.25;

		// move down 
		prob += findProbability(m, n, x + 1,
			y, N - 1) * 0.25;

		// move left 
		prob += findProbability(m, n, x, y - 1,
			N - 1) * 0.25;

		return prob;
    }
}
