class CountPathsToReachOriginFromPoint {
    int reachOrigin(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }

        return reachOrigin(m - 1, n) + reachOrigin(m, n - 1);
    }
}
