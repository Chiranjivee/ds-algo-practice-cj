class ShortestPathWithKEdges {
    // Define number of vertices in the graph and inifinite value 
    static final int V = 4;
    static final int INF = Integer.MAX_VALUE;

    // A Dynamic programming based function to find the shortest path 
    // from u to v with exactly k edges. 
    int shortestPath(int graph[][], int u, int v, int k) {
        // Table to be filled up using DP. The value sp[i][j][e] will 
        // store weight of the shortest path from i to j with exactly 
        // k edges 
        int sp[][][] = new int[V][V][k + 1];

        // Loop for number of edges from 0 to k 
        for (int e = 0; e<= k; e++) {
            // for every source
            for (int i = 0; i<V; i++) {
                // for every destination 
                for (int j = 0; j<V; j++) {
                    // initialize value 
                    sp[i][j][e] = INF;

                    // from base cases 
                    if (e == 0 && i == j) // if you are one same src and dest
                        sp[i][j][e] = 0;
                    if (e == 1 && graph[i][j] != INF) // if k == 1 and you have edge between i and j
                        sp[i][j][e] = graph[i][j];

                    // go to adjacent only when number of edges is 
                    // more than 1 
                    if (e > 1) { // for every adjacent edge to i
                        for (int a = 0; a < V; a++) {
                            // There should be an edge from i to a and 
                            // a should not be same as either i or j 
                            if (graph[i][a] != INF && i != a && j != a && sp[a][j][e - 1] != INF)
                                sp[i][j][e] = Math.min(sp[i][j][e], graph[i][a] + sp[a][j][e - 1]);
                        }
                    }
                }
            }
        }
        return sp[u][v][k];
    }
}