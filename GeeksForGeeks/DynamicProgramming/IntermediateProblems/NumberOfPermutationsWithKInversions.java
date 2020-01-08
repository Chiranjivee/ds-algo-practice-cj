class NumberOfPermutationsWithKInversions {
    static int memo[][] = new int[M][M];

    // method recursively calculates permutation with 
    // K inversion 
    static int numberOfPermWithKInversion(int N, int K) {

        // base cases 
        if (N == 0)
            return 0;
        if (K == 0)
            return 1;

        // if already solved then return result directly 
        if (memo[N][K] != 0)
            return memo[N][K];

        // calling recursively all subproblem of 
        // permutation size N - 1 
        int sum = 0;
        for (int i = 0; i<= K; i++) {

            // Call recursively only if total inversion 
            // to be made are less than size 
            if (i<= N - 1)
                sum += numberOfPermWithKInversion(N - 1, K - i);
        }

        // store result into memo 
        memo[N][K] = sum;

        return sum;
    }
}
