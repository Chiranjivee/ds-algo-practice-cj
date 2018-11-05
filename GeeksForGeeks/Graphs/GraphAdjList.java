import java.util.LinkedList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Queue;

class Graph {
    Map<GraphNode, LinkedList<GraphNode>> adjList;
    Set<GraphNode> vertices;

    public Graph() {
        this.adjList = new LinkedHashMap<>();
        this.vertices = new HashSet<>();
    }

    public void addVertex(GraphNode vert) {
        this.vertices.add(vert);
        this.adjList.put(vert, new LinkedList<>());
    }

    public void removeVertex(GraphNode vert) {
        this.vertices.remove(vert);
        this.adjList.remove(vert);

        for (Map.Entry<GraphNode, LinkedList<GraphNode>> entry: adjList.entrySet()) {
            LinkedList<GraphNode> tempLL = entry.getValue();
            tempLL.remove(vert);
        }
    }

    public void addEdge(GraphNode vertx1, GraphNode vertx2) {
        if (!this.vertices.contains(vertx1)) {
            addVertex(vertx1);
        }

        if (!this.vertices.contains(vertx2)) {
            addVertex(vertx2);
        }

        this.adjList.get(vertx1).addFirst(vertx2);
    }

    public void removeEdge(GraphNode vertx1, GraphNode vertx2) {
        if (!this.vertices.contains(vertx1)) {
            return;
        }

        if (!this.vertices.contains(vertx2)) {
            return;
        }

        this.adjList.get(vertx1).remove(vertx2);
    }

    public void showAdjList() {
        System.out.println("Printing adj list:");
        for (Map.Entry<GraphNode, LinkedList<GraphNode>> entry: adjList.entrySet()) {
            LinkedList<GraphNode> tempLL = entry.getValue();
            System.out.println("[ " + entry.getKey().data + " ] => " + printList(tempLL));
        }
    }

    private String printList(LinkedList<GraphNode> list) {
        StringBuilder builder = new StringBuilder();
        for (GraphNode node: list) {
            builder.append(node.data + " => ");
        }
        builder.append("X");
        return builder.toString();
    }

    public void breadthFirstSearchOnGraph() {
        resetVertices();
        for (GraphNode node : vertices) {
            if (!node.visited) breadthFirstSearchFromNode(node);
        }
        resetVertices();
    }

    public void breadthFirstSearchFromNode(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        
        node.visited = true;
        queue.offer(node);

        while (!queue.isEmpty()) {
            GraphNode temp = queue.poll();
            System.out.print(temp.data + " => ");
            for (GraphNode neighBour : adjList.get(temp)) {
                if (!neighBour.visited) {
                    neighBour.visited = true;
                    queue.offer(neighBour);
                }
            }
        }
    }

    public void resetVertices() {
        for (GraphNode node : vertices) {
            node.visited = false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        GraphNode one = new GraphNode(1);
        GraphNode two = new GraphNode(2);
        GraphNode three = new GraphNode(3);
        GraphNode four = new GraphNode(4);

        graph.addVertex(one);
        graph.addVertex(two);
        graph.addVertex(three);
        graph.addVertex(four);
        
        graph.addEdge(one, two);
        graph.addEdge(one, three);
        graph.addEdge(three, four);

        graph.showAdjList();

        graph.breadthFirstSearchOnGraph();
        graph.breadthFirstSearchFromNode(one);
    }
}

class GraphNode {
    int data;
    boolean visited;
    public GraphNode(int data) {
        this.data = data;
        this.visited = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        
        GraphNode temp = (GraphNode) o;
        if (temp.data == this.data) {
            return true;
        }
        return false;
    }
}