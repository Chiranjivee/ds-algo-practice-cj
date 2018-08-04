class Graph {
    private boolean adjMatrix[][];
    private int vertexCount;
    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        this.adjMatrix = new boolean[vertexCount][vertexCount];
    }

    public void addEdge(int i, int j) {
        if (0 <= i && i < vertexCount && 0 <= j && j < vertexCount) {
            this.adjMatrix[i][j] = true;
            this.adjMatrix[j][i] = true;
        }
    }

    public void removeEdge(int i, int j) {
        if (0 <= i && i < vertexCount && 0 <= j && j < vertexCount) {
            this.adjMatrix[i][j] = false;
            this.adjMatrix[j][i] = false;
        }
    }

    public boolean isEdge(int i, int j) {
        if (0 <= i && i < vertexCount && 0 <=j && j < vertexCount) {
            return this.adjMatrix[i][j];
        }

        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);

        System.out.println(graph.isEdge(0, 1));
        System.out.println(graph.isEdge(2, 3));
    }
}
