import java.util.Queue;
import java.util.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

class GraphPQNode {
    int node;
    int distance;

    public GraphPQNode(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        GraphPQNode temp = (GraphPQNode) o;
        if (this.node == temp.node && this.distance == temp.distance) {
            return true;
        }
        return false;
    }
}

class Graph {
    int [] vertices;
    int maxVerticesCount;
    int verticesCount;

    int [][] adjMatrix;

    Graph(int vertices) {
        this.maxVerticesCount = vertices;
        this.verticesCount = 0;
        this.vertices = new int[maxVerticesCount];
        this.adjMatrix = new int[maxVerticesCount][maxVerticesCount];
    }

    void addVertex(int v) {
        this.vertices[verticesCount++] = v;
    }

    void addEdge(int u, int v, int weight) {
        if (u >= 0 && u < verticesCount
            && v >= 0 && v < verticesCount) {
                adjMatrix[u][v] = weight;
        }
    }

    int getEdgeCount() {
        
    }

    void removeEdge(int u, int v) {
        if (u >= 0 && u < verticesCount
            && v >= 0 && v < verticesCount) {
                adjMatrix[u][v] = 0;
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

    /**
     * this function will do a bfs traversal on graph
     * with the given starting node index
    */
    void bfs(int startNodeIndex) {
        System.out.println("Starting bfs from node: " + startNodeIndex);
        Queue<Integer> queue = new ArrayDeque<>();

        boolean visited[] = new boolean[maxVerticesCount];
        queue.offer(startNodeIndex);
        visited[startNodeIndex] =  true;

        while (!queue.isEmpty()) {
            Integer vertexIndex = queue.poll();
            System.out.print(vertexIndex + " => ");
            for (int i = 0; i < maxVerticesCount; i++) {
                if (adjMatrix[vertexIndex][i] != 0 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println(" X");
        System.out.println("Done BFS");
    }

    void findShortestPathUsingDijkstra(int startNodeIndex, int [] parent, int [] distance) {
        PriorityQueue<GraphPQNode> queue = new PriorityQueue<>(11, (a, b) -> a.distance - b.distance);
        for (int i = 0; i < maxVerticesCount; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        boolean[] SPT = new boolean[maxVerticesCount];
        distance[startNodeIndex] = 0;
        parent[startNodeIndex] = -1;
        queue.offer(new GraphPQNode(startNodeIndex, distance[startNodeIndex]));

        while (!queue.isEmpty()) {
            GraphPQNode current = queue.poll();
            SPT[current.node] = true;
            for (int i = 0; i < maxVerticesCount; i++) {
                if (adjMatrix[current.node][i] != 0 && !SPT[i]) {
                    int newNeighbourDistance = distance[current.node] + adjMatrix[current.node][i];
                    GraphPQNode neighBour = new GraphPQNode(i, distance[i]);
                    if (newNeighbourDistance < distance[i]) {
                        distance[i] = newNeighbourDistance;
                        parent[i] = current.node;
                        queue.remove(neighBour);
                        neighBour.distance = newNeighbourDistance;
                        queue.add(neighBour);
                    }
                }
            }
        }
    }

    /**
     * This function will do a bfs traversal on graph
     * with the given starting node index
    */
    void dfs(int startNodeIndex) {
        System.out.println("Starting dfs from node: " + startNodeIndex);
        Stack<Integer> stack = new Stack<>();

        boolean visited[] = new boolean[maxVerticesCount];
        stack.push(startNodeIndex);
        visited[startNodeIndex] =  true;

        while (!stack.isEmpty()) {
            Integer vertexIndex = stack.pop();
            System.out.print(vertexIndex + " => ");
            for (int i = 0; i < maxVerticesCount; i++) {
                if (adjMatrix[vertexIndex][i] != 0 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println(" X");
        System.out.println("Done DFS");
    }

    
    /**
     * This function will do a dfs and detect a cycle
     * in a graph.
    */
    boolean hasCycle() {
        boolean visited [] = new boolean[maxVerticesCount];
        boolean recursiveStack [] = new boolean[maxVerticesCount];
        boolean hasCycle = false;
        for (int startNodeIndex = 0; startNodeIndex < verticesCount; startNodeIndex++) {
            if (visited[startNodeIndex]) continue;

            Stack<Integer> stack = new Stack<>();
            stack.push(startNodeIndex);
            visited[startNodeIndex] =  true;
            recursiveStack[startNodeIndex] = true;

            while (!stack.isEmpty()) {
                Integer vertexIndex = stack.pop();
                for (int i = 0; i < maxVerticesCount; i++) {
                    if (adjMatrix[vertexIndex][i] != 0 && !visited[i]) {
                        stack.push(i);
                        visited[i] = true;
                    } else if (adjMatrix[vertexIndex][i] != 0 && visited[i]) {
                        if (recursiveStack[i] == true) {
                            return true;
                        }
                    }
                }
            }
            recursiveStack[startNodeIndex] = false;
        }

        return hasCycle;
    }

    LinkedList<Integer> printPathFromSrc(int [] distance, int [] parent, int src, int dest) {
        LinkedList<Integer> path = new LinkedList<>();
        
        while (dest != src) {
            path.addFirst(dest);
            dest = parent[dest];
        }
        path.addFirst(src);
        return path;
    }

    /*
        (0) --5--> (1)
                  / |
                /   1
               7    |
             /      |
           /        |
          v         v
        (2) --2--> (3)
    */
    public static void main(String [] args) {
        Graph graph = new Graph(4);
        // graph.addVertex(0);
        // graph.addVertex(1);
        // graph.addVertex(2);
        // graph.addVertex(3);

        // graph.addEdge(0, 1, 5);
        // graph.addEdge(2, 3, 2);
        // graph.addEdge(1, 3, 1);
        // graph.addEdge(1, 2, 7);
        // graph.addEdge(2, 0, 7);

        // graph.showAdjMatrix();

        // graph.bfs(0);
        // graph.bfs(3);

        // System.out.println("Graph has cycle: " + graph.hasCycle());
        // int [] distance = new int[graph.maxVerticesCount];
        // int [] parent = new int [graph.maxVerticesCount];

        // graph.findShortestPathUsingDijkstra(0, parent, distance);
        // System.out.println(Arrays.toString(distance));
        // System.out.println(Arrays.toString(parent));

        // String result = graph.printPathFromSrc(distance, parent, 0, 2).toString();
        // System.out.println(result);

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);

        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, -10);

        int [] distance = new int[graph.maxVerticesCount];
        int [] parent = new int [graph.maxVerticesCount];
        graph.findShortestPathUsingDijkstra(0, parent, distance);

        System.out.println(Arrays.toString(distance));
        // System.out.println(Arrays.toString(parent));
        String result = graph.printPathFromSrc(distance, parent, 0, 2).toString();
        System.out.println(result);
    }
}


