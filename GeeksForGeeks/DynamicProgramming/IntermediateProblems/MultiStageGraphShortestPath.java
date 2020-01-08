class MultiStageGraphShortestPath {
    static int N = 8;
    static int INF = Integer.MAX_VALUE;

    // Returns shortest distance from 0 to  
    // N-1.  
    public static int shortestDist(int[][] graph) {

        // dist[i] is going to store shortest  
        // distance from node i to node N-1.  
        int[] dist = new int[N];

        dist[N - 1] = 0;

        // Calculating shortest path for  
        // rest of the nodes  
        for (int i = N - 2; i >= 0; i--) {

            // Initialize distance from i to  
            // destination (N-1)  
            dist[i] = INF;

            // Check all nodes of next stages  
            // to find shortest distance from  
            // i to N-1.  
            for (int j = i; j<N; j++) {
                // Reject if no edge exists  
                if (graph[i][j] == INF) {
                    continue;
                }

                // We apply recursive equation to  
                // distance to target through j.  
                // and compare with minimum distance  
                // so far.  
                dist[i] = Math.min(dist[i], graph[i][j] + dist[j]);
            }
        }

        return dist[0];
    }
}
