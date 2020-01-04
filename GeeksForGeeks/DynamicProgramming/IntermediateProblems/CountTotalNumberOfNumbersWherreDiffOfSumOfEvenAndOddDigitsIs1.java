class CountTotalNumberOfNumbersWhereDiffOfSumOfEvenAndOddDigitsIsOne {
    public int solve(int digits, int eSum, int oSum, int isOdd, int n) {

        if (digits == n) {
            if (eSum - oSum == 1) { 
                return 1;
            } else {
                return 0;
            }
        }

        int ans = 0;

        if (isOdd == 1) {
            for (int i = 0; i <= 9; i++) {
                ans += solve(digits + 1, eSum, oSum + i, 0, n);
            }
        } else {
            for (int i = 0; i <= 9; i++) {
                ans += solve(digits + 1, eSum + i, oSum, 1, n);
            }
        }

        return ans;
    }

    public int solveParent(int n) {
        int ans = 0;
        for (int i = 1; i <= 9; i++) {
            ans += solve(1, i, 0, 1, n);
        }

        return ans;
    }
}