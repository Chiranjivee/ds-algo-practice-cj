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
            this.graph = new HashSet<>();
        }
    }

    class Node
    {
        String name;
        List<Node> shortestPathFromSource;
        Map<Node, Integers> neighbours;
        int distance = Integer.MAX_VALUE;

        public Node(String name) {
            this.name = name;
            this.neighbours = new HashMap<>();
            this.shortestPathFromSource = new ArrayList<>();
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public void addNeighbour(Node neighbour, int edgeLength)
        {
            this.neighbours.put(neighbour, edgeLength);
        }
    }

    public static void main(String[] args) {

    }
}