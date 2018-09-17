import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class Solution {
    class GraphNode {
        int data;
        boolean visited;
        List<GraphNode> neighbours;

        public GraphNode(int data) {
            this.data = data;
            this.visited = false;
            this.neighbours = new ArrayList<>();
        }

        public int getData() {
            return this.data;
        }

        public void setVisited(boolean value) {
            this.visited = value;
        }

        public boolean isVisited() {
            return this.visited;
        }

        public void addNeighbour(GraphNode g) {
            this.neighbours.add(g);
        }

        public List<GraphNode> getAllNeighbours() {
            return this.neighbours;
        }

        public void removeNeighbour(GraphNode g) {
            this.neighbours.remove(g);
        }
    }

    class Graph {
        List<GraphNode> nodes;
        public Graph() {
            this.nodes = new ArrayList<>();
        }

        public void addNode(GraphNode g) {
            this.nodes.add(g);
        }

        public void removeNode(GraphNode g) {
            this.nodes.remove(g);
        }

        public void depthFirstSearch() {
            // Mark all nodes unvisited;
            for (GraphNode node : this.nodes)
                node.setVisited(false);
            
            Stack<GraphNode> stack = new Stack<>();
            for (GraphNode node : this.nodes) {
                if (node.isVisited()) continue;

                stack.push(node);

                while (!stack.isEmpty()) {
                    // get the current node;
                    GraphNode current = stack.pop();
                    current.setVisited(true);
                    System.out.print(current.getData() + " => ");

                    List<GraphNode> currentNeighbours = current.getAllNeighbours();
                    for (GraphNode neighbour : currentNeighbours) {
                        if (neighbour.isVisited()) continue;
                        stack.push(neighbour);
                    }
                }
            }
        }
    }

    public void execute() {
        Graph graph = new Graph();
        GraphNode g1 = new GraphNode(1);
        GraphNode g2 = new GraphNode(2);
        GraphNode g3 = new GraphNode(3);
        GraphNode g4 = new GraphNode(4);

        g1.addNeighbour(g2);
        g2.addNeighbour(g3);
        g3.addNeighbour(g4);
        g4.addNeighbour(g1);

        graph.addNode(g1);
        graph.addNode(g2);
        graph.addNode(g3);
        graph.addNode(g4);

        graph.depthFirstSearch();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.execute();
    }
}