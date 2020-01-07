class FindMinCostToReachDestinationUsingTrain {
    public int solve(int [] train, int s, int d) {
        if (s == d || s + 1 == d) return cost[s][d];

        int min = cost[s][d];
        for (int i = s + 1; i < d; i++) {
            // try all intermediate stations
            int c = minCostRec(cost, s, i) + minCostRec(cost, i, d);
            if (c < min) {
                min = c;
            }
        }

        return min;
    }
}
