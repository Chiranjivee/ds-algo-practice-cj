class CountOfNDigitNumberWhoseSumOfDigitEqualSum {
    int getCount(int n, int sum) {
        int [][] lookup = new int[n + 1][sum + 1];
        fillLookupWithNegativeOne(lookup);

        int ans = 0;
        for (int i = 1; i <= 9; i++) {
            if (sum - i >= 0)
                ans += countRec(n - 1, sum - i);
        }

        return ans;
    }

    public int countRec(int n, int sum, int [][] lookup) {
        if (n == 0) {
            if (sum == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (lookup[n][sum] != -1) {
            return lookup[n][sum];
        }

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += countRec(n - 1, sum - i; lookup);
        }

        return lookup[n][sum] = ans;
    }
}
