class Solution {
    static int MOD = 1_000_000_000 + 7;
    public int numTilings(int N) {
        if (N == 0) return 1;
        if (N == 1 || N == 2) return N;
        int [] dp = new int[N + 1];
        numTilings(N, dp);
        return dp[N];
    }
    
    public int numTilings(int N, int[] dp) {
        if (N < 0) return 0;
        if (N == 0) return 1;
        if (N == 1 || N == 2) return N;
        if (dp[N] != 0) return dp[N];

        int option1 = numTilings(N - 1, dp) * 2;
        int option2 = numTilings(N - 3, dp);
        return dp[N] = (option1 % MOD + option2 % MOD) % MOD;
    }
}
