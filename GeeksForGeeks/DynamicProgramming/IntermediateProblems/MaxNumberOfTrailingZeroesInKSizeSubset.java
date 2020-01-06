class MaxTrailingZeroesInSubset {
    final static int MAX5 = 100;
    // subset[i][j] means max number of 2 we can collect, if ith number have j 5's
    static int maximumZeros(int arr[], int n, int k) {
        // Initializing each value with -1;
        int subset[][] = new int[k + 1][MAX5 + 5];
        // Fill each row with 1.0
        for (int[] row : subset) {
            Arrays.fill(row, -1);
        }

        subset[0][0] = 0; 
  
        for (int p = 0; p < n; p++) {
            int pw2 = 0, pw5 = 0;
  
            // Calculating maximal power of 2 for
            // arr[p].
            while (arr[p] % 2 == 0) {
                pw2++;
                arr[p] /= 2;
            }
  
            // Calculating maximal power of 5 for
            // arr[p].
            while (arr[p] % 5 == 0) {
                pw5++;
                arr[p] /= 5;
            }
  
            // Calculating subset[i][j] for maximum
            // amount of twos we can collect by
            // checking first i numbers and taking
            // j of them with total power of five.
            for (int i = k - 1; i >= 0; i--) {
                for (int j = 0; j < MAX5; j++) {
                    // If subset[i][j] is not calculated.
                    if (subset[i][j] != -1) {
                        subset[i + 1][j + pw5] = Math.max(subset[i + 1][j + pw5], subset[i][j] + pw2); 
                    }
                }
            }
        }
  
        // Calculating maximal number of zeros.
        // by taking minimum of 5 or 2 and then
        // taking maximum.
        int ans = 0;
        for (int i = 0; i < MAX5; i++) {
            ans = Math.max(ans, Math.min(i, subset[k][i]));
        }

        return ans;
    }
}
