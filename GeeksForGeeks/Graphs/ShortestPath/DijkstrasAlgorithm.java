class DijkstrasAlgorithm {
    /**
     * 
     * Shortest path to all other nodes from nodes.
     */
    public void dijkstra(int [][] graph, int src) {
        int V = graph.length;
        int dist [] = new int[V];

        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;
        for (int tempVertex = 0; tempVertex < V - 1; tempVertex++) {
            // pick a vertex
            int u = minDistance(dist, sptSet);

            // mark picked vertex in spt
            sptSet[u] = true;

            //  for all adj of u
            for (int v = 0; v < V; v++) {
                if (!sptSet[a] && graph[u][v] == 1 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
    }

    int minDistance(int dist[], bool sptSet[]) {
        // Initialize min value 
        int min = INT_MAX, min_index;
    
        for (int v = 0; v<V; v++)
            if (sptSet[v] == false && dist[v]<= min)
                min = dist[v], min_index = v;
    
        return min_index;
    }
}
