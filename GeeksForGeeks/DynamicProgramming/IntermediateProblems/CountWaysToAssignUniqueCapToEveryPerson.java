class CountWaysToAssignUniqueCapToEveryPerson {
    public int countWays(int n, int k) {
        return factorial(k) * factorial(n) / factorial(n - k);
    }
}
