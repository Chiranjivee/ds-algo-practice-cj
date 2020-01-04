class CountNumberOfBinaryStringWithoutConsecutiveOnes {
    public int count(int n) {
        // a[i] - num of binary string with no conseq 1 ending with 0 -> means we can only add 0 or 1
        // b[i] - num of binary string with no conseq 1 ending with 1 -> means we can only add 0

        // a[i] = a[i - 1] + b[i - 1]
        // b[i] = a[i - 1]
        int [] a = new int[n + 1];
        int [] b = new int[n + 1];

        a[1] = 1;
        b[1] = 1;

        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = b[i - 1];
        }

        return a[n] + b[n];
    }
}
