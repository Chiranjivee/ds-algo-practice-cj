class CountAllPossiblePathsWithKEdgesFromSourceToDestination {
    public int countKPaths(int [][] graph, int u, int v, int k) {
        int V = graph.length;
        int [][][] dp = new int[V][V][k];

        for (int e = 0; e < k; e++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    dp[i][j][e] = 0;
                    if (e == 0 && i == j) {
                        dp[i][j][e] = 1;
                    }

                    if (e == 1 && graph[i][j] != 0) {
                        dp[i][j][e] = 1;
                    }

                    if (e > 1) {
                        for (int l = 0; l < V; l++) {
                            if (graph[i][l] != 0){ 
                                dp[i][j][e] += dp[i][l][e - 1];
                            }
                        }
                    }
                }
            }
        }

        return dp[u][v][k];
    }
}
