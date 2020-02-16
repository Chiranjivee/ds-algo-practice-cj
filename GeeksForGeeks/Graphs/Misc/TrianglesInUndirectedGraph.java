class TrianglesInGraph {
    int getTrace(int graph[][]) {
        int trace = 0;
    
        for (int i = 0; i<V; i++) {
            trace += graph[i][i];
        }

        return trace;
    }

    int triangleInGraph(int graph[][]) {

        int[][] aux2 = new int[V][V];
        int[][] aux3 = new int[V][V];

        for (int i = 0; i<V; ++i) {
            for (int j = 0; j<V; ++j) {
                aux2[i][j] = aux3[i][j] = 0;
            }
        }

        multiply(graph, graph, aux2);
        multiply(graph, aux2, aux3);
    
        int trace = getTrace(aux3);
        return trace / 6;
    }
}
