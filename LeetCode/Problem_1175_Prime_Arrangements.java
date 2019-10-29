class Solution {
    private int MOD = (int) (1e9 + 7);

    public int numPrimeArrangements(int n) {
        int numOfPrimesTillN = numOfPrime(n);
        long numOfWaysToArrangePrimes = factorial(numOfPrimesTillN);
        long numOfWaysToArrangeNonPrimes = factorial(n - numOfPrimesTillN);
        long totalNumberOfWays = (numOfWaysToArrangePrimes % MOD * numOfWaysToArrangeNonPrimes % MOD) % MOD;

        return (int) totalNumberOfWays;
    }

    private int numOfPrime(int n) {

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        int primesLeft = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primesLeft++;
                for (int j = i; j * i <= n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        return primesLeft;
    }

    private long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = (res % MOD * i % MOD) % (MOD);
        }
        
        return res;
    }
}
