class Graph {
    int maxNumberOfVertices;
    int [][] adjMatrix;

    public Graph(int numberOfVertices) {
        this.maxNumberOfVertices = numberOfVertices;
        this.adjMatrix = new int [maxNumberOfVertices][maxNumberOfVertices];
    }

    public void addEdge(int u, int v) {
        if (u >= 0 && u < maxNumberOfVertices && v >= 0 && v < maxNumberOfVertices) {
            adjMatrix[u][v] = 1;
        }
    }

    public void removeEdge(int u, int v) {
        if (u >= 0 && u < maxNumberOfVertices && v >= 0 && v < maxNumberOfVertices) {
            adjMatrix[u][v] = 0;
        }
    }

    public boolean showArticulationPoints() {
        int count = 0;


        if (count == 0) {
            System.out.println("No articulation points detected."); 
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

    }
}