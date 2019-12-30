class FloydWarshalAlgorithm {
    public void floydWarshalAlgorithm(int [][] graph) {
        int [][] dp = new int[graph.length][graph.length];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0;j j < graph.length; j++) {
                dp[i][j] = graph[i][j];
            }
        }

        int v = graph.length;
        // for every vertex as intermediate vertex
        for (int k = 0; k < v; k++) {

            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = dp[i][k] + d[k][j];
                    }
                }
            }
        }

        printSolution(dp);
    }
}
