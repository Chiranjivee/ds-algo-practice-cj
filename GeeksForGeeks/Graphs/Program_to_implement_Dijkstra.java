import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Given a weighted graph with non-negative edges and a source node,'
 * dijkstra algorithm determies shortest paths to all other nodes 
 * available in the graph.
 */
class DijkstraImpl {
    class Graph {
        Set<Node> graphNodes;

        Graph() {
            this.graphNodes = new HashSet<>();
        }

        public void addNode(Node node) {
            this.graphNodes.add(node);
        }
    }

    class Node
    {
        String name;
        List<Node> shortestPathFromSource;
        Map<Node, Integer> neighbours;
        int distance = Integer.MAX_VALUE;

        public Node(String name) {
            this.name = name;
            this.neighbours = new HashMap<>();
            this.shortestPathFromSource = new ArrayList<>();
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public void addDestination(Node neighbour, int edgeLength)
        {
            this.neighbours.put(neighbour, edgeLength);
        }
    }

    public void execute() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D"); 
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
         
        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);
         
        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);
         
        nodeC.addDestination(nodeE, 10);
         
        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);
         
        nodeF.addDestination(nodeE, 5);
         
        Graph graph = new Graph();
         
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
    }
    public static void main(String[] args) {
        DijkstraImpl impl = new DijkstraImpl();
        impl.execute();
    }
}