class BellmanFordAlgorithm {
    // find shortest path to all other vertices from source
    public void bellmanFordAlgorithm(Graph graph, int src) {
        int [] dist = new int[graph.v];
        for (int i = 0; i < graph.v; i++) {
            if (i == src) {
                dist[i] = 0;
            } else {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // relax edges [v] - 1 times
        for (int i = 1; i < graph.v; i++) {
            for (int j = 0; j < graph.e; j++) {
                int u = graph.edges[j].src;
                int v = graph.edges[j].dest;
                int weight = graph.edges[j].weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // check for -ve weight cycle
        for (int i = 0; i < graph.e; i++) {
            int u = graph.edges[i].src;
            int v = graph.edges[i].dest;
            int weight = graph.edges[i].weight;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Negative weight cycle");
                return;
            }
        }
    }
}

class Graph {
    Edge[] edges;
    int v;
    int e;
}

class Edge {
    int src;
    int dest;
    int weight;
}
