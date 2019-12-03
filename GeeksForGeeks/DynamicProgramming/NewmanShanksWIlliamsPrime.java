
/**
 * A prime number which could be 
 * 
 * It's a sequence of prime numbers: 
 * S(n) = 2S(n - 1) + S(n - 2)
 * 
 * Seq eg: 1 1 3 7 ...
 */
class NewmanShanksWilliamsPrime {

    public int nthNewManShanksWilliamsPrimeNaive(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }


        return 2 * nthNewManShanksWilliamsPrime(n - 1) + 
                nthNewManShanksWilliamsPrime(n - 2);
    }

    public int nthNewManShanksWilliamsPrimeOptimized(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        int secLast = 1;
        int last = 1;

        int result = 0;
        while (n-- > 2) {
            result = last + secLast;
            secLast = last;
            last = result;
        }

        return result;
    }
}
