import java.util.PriorityQueue;

class Graph {
    int maxVertexCount;
    int [] vertices;
    int [][] adjMatrix;

    int vertexCount;

    public Graph(int maxVertexCount) {
        this.maxVertexCount = maxVertexCount;
        this.vertices = new int[maxVertexCount];
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
    }

    public void addVertex(int i) {
        vertices[vertexCount++] = i;
    }

    public void addEdge(int u, int v, int w) {
        this.adjMatrix[u][v] = w;
        this.adjMatrix[v][u] = w;
    }

    public void removeEdge(int u, int v, int w) {
        this.adjMatrix[u][v] = w;
        this.adjMatrix[v][u] = w;
    }

    public void prims() {
        PriorityQueue<PQNode> pq = new PriorityQueue<>(11, (a, b) -> a.weight - b.weight);
        int [] distance = new int[maxVertexCount];
        int [] parent = new int[maxVertexCount];
        for (int i = 0; i < maxVertexCount; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        boolean [] solution = new boolean[maxVertexCount];
        int srcVertex = 0;
        distance[srcVertex] = 0;
        parent[srcVertex] = -1;

        PQNode srcPqNode = new PQNode(srcVertex, 0);
        pq.offer(srcPqNode);
        while (!pq.isEmpty()) {
            PQNode pqNode = pq.poll();
            solution[pqNode.vertex] = true;
            for (int i = 0; i < maxVertexCount; i++) {
                if (adjMatrix[pqNode.vertex][i] != 0 && !solution[i]) {
                    int neighBourDistance = pqNode.weight + adjMatrix[pqNode.vertex][i];
                    if (neighBourDistance < distance[i]) {
                        distance[i] = adjMatrix[pqNode.vertex][i];
                        parent[i] = pqNode.vertex;
                        PQNode neighbourPqNode = 
                            new PQNode(i, adjMatrix[pqNode.vertex][i]);

                        pq.remove(neighbourPqNode);
                        pq.offer(neighbourPqNode);
                    }
                }
            }
        }

        System.out.println("Printing spanning tree");
        for (int i = 1; i < solution.length; i++) {
            System.out.println(parent[i] + " - " + i + " " + " -- " + adjMatrix[i][parent[i]]);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(0, 1, 9);
        graph.addEdge(1, 2, 12);
        graph.addEdge(0, 2, 7);
        graph.addEdge(0, 3, 4);
        graph.addEdge(1, 4, 3);
        graph.addEdge(3, 4, 1);

        graph.prims();
    }
}

class PQNode {
    int vertex;
    int weight;

    PQNode(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o){ 
        if (this == o) {
            return true;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        PQNode temp = (PQNode) o;
        if (temp.weight == this.weight && temp.vertex == this.vertex) {
            return true;
        }

        return false;
    }
}