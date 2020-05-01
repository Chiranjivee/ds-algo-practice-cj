class CoinChangeProblem {

    static int count(int [] S, int n, int m) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (m <= 0 && n >= 1) {
            return 0;
        }

        return 
            count(S, n - 1, m) + 
            count(S, n, m - S[m - 1]);
    }
}
