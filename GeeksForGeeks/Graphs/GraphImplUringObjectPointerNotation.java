import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.LinkedHashSet;

class GraphNode {
    int data;
    List<GraphNode> neighbours;

    public GraphNode(int data) {
        this.data = data;
        this.neighbours = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        GraphNode node = (GraphNode) o;
        if (node.data == this.data &&
            node.neighbours == this.neighbours) {
                return true;
        }

        return false;
    }
}

class Graph {
    Set<GraphNode> vertices;

    public Graph() {
        this.vertices = new LinkedHashSet<>();
    }

    public void addVertex(GraphNode vertex) {
        this.vertices.add(vertex);
    }

    public void removeVertex(GraphNode vertex) {
        this.vertices.remove(vertex);
    }

    public void addEdge(GraphNode src, GraphNode dest) {
        boolean deleteSrc = this.vertices.remove(src);
        boolean deleteDest = this.vertices.remove(dest);
        if (!(deleteSrc && deleteDest)) {
            return;
        }

        src.neighbours.add(dest);
        this.vertices.add(src);
        this.vertices.add(dest);
    }

    public void removeEdge(GraphNode src, GraphNode dest) {
        boolean deleteSrc = this.vertices.remove(src);
        boolean deleteDest = this.vertices.remove(dest);
        if (!(deleteSrc && deleteDest)) {
            return;
        }

        src.neighbours.remove(dest);
        this.vertices.add(src);
        this.vertices.add(dest);
    }

    public void showGraph() {
        for (GraphNode node : vertices) {
            System.out.println("[ " + node.data + " ] => " + showNeighbours(node.neighbours));
        }
    }

    private String showNeighbours(List<GraphNode> neighbours) {
        StringBuilder builder = new StringBuilder();
        for (GraphNode node : neighbours) {
            builder.append(node.data + " => ");
        }

        builder.append("X");
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println("Inside main");
        Graph graph = new Graph();

        GraphNode one = new GraphNode(1);
        GraphNode two = new GraphNode(2);
        GraphNode three = new GraphNode(3);
        GraphNode four = new GraphNode(4);

        graph.addVertex(one);
        graph.addVertex(two);
        graph.addVertex(three);
        graph.addVertex(four);

        graph.showGraph();

        graph.addEdge(one, two);
        graph.addEdge(two, three);
        graph.addEdge(three, four);
        graph.addEdge(one, three);

        graph.showGraph();
    }
}