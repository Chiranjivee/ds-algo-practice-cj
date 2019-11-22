/**
 * 
 * You have been given a set of coins of different denominations. like {2, 3, 5}
 * Calculate the total number of ways such that, we can form a sum of N, using these number of coins.
 * 
 */
class CoinChangeProblem {

    public static int countWaysNaive(int [] denominations, int n) {
        return countWaysNaiveRecursive(denominations, 0, n);
    }

    public static int countWaysNaiveRecursive(int [] denominations, int idx, int N) {

        if (N == 0) {
            return 1;
        }

        if (N < 0) {
            return 0;
        }

        if (idx >= denominations.length && N >= 1) {
            return 0;
        }

        return 
            countWaysNaiveRecursive(denominations, idx + 1, N)
                + countWaysNaiveRecursive(denominations, idx, N - denominations[idx]);
    }

    public static int countWaysDP(int [] denominations, int N) {
        int [] dp = new int [N + 1];

        dp[0] = 1;
        for (int coinValue : denominations) {
            for (int j = coinValue; j <= N; j++) {
                dp[j] += dp[j - coinValue];
            }
        }

        return dp[N];
    }

    public static void main(String[] args) {
        int [] denominations = {2, 3, 5};
        int N = 7;
        System.out.println(countWaysNaive(denominations, N));
    }
}
