class NumberOfSolsOfLinearEquationOfNVariables {
    public int solve(int [] coeff, int rhs) {
        // This is basically a coin change problem.

        int [] dp = new int[rhs + 1];
        dp[0] = 1;

        for (int x : coeff) {
            for (int i = x; i <= rhs; i++) {
                dp[i] += dp[i - x]; 
            }
        }

        return dp[rhs];
    }
}

