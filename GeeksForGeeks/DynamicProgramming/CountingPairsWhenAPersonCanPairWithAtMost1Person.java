class CountingPairs {
    public int waysToMakePairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return 
            waysToMakePairs(n - 1) + 
            (n - 1) * waysToMakePairs(n - 2);
    }
}
