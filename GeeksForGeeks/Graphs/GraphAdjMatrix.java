class Graph {
    int [] vertices;
    int maxVerticesCount;
    int verticesCount;

    boolean [][] adjMatrix;

    Graph(int vertices) {
        this.maxVerticesCount = vertices;
        this.verticesCount = 0;
        this.vertices = new int[maxVerticesCount];
        this.adjMatrix = new boolean[maxVerticesCount][maxVerticesCount];
    }

    void addVertex(int v) {
        this.vertices[verticesCount++] = v;
    }

    void addEdge(int u, int v) {
        if (u >= 0 && u < verticesCount
            && v >= 0 && v < verticesCount) {
                adjMatrix[u][v] = true;
        }
    }

    void removeEdge(int u, int v) {
        if (u >= 0 && u < verticesCount
            && v >= 0 && v < verticesCount) {
                adjMatrix[u][v] = false;
        }
    }

    void showAdjMatrix() {
        for (int i = 0; i < maxVerticesCount; i++) {
            for (int j = 0; j < maxVerticesCount; j++) {
                System.out.print(String.format("%10s", adjMatrix[i][j]));
            }
            System.out.println();
        }
    }
    public static void main(String [] args) {
        Graph graph = new Graph(4);
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        graph.addEdge(0, 1);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);

        graph.showAdjMatrix();
    }
}


