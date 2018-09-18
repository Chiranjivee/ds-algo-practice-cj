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

        public void getMotherVertex() {
            int totalNodes = nodes.size();
            System.out.println("Total nodes: " + totalNodes);
            for (GraphNode node : nodes) {
                int reachableNodes = depthFirstSearch(node);
                System.out.println("Rechable nodes: " + reachableNodes);
                if (reachableNodes == totalNodes) {
                    System.out.println("Found Mother vertex: " + node.data);
                    return;
                }
            }

            System.out.println("No mother vertex found.");
        }

        private void markAllNodesUnvisited() {
            // Mark all nodes unvisited;
            for (GraphNode node : this.nodes)
                node.setVisited(false);
        }

        public int depthFirstSearch(GraphNode start) {
            // Mark all nodes unvisited;
            markAllNodesUnvisited();
            
            int reachableNodes = 0;
            Stack<GraphNode> stack = new Stack<>();
            stack.push(start);
            for (GraphNode node : this.nodes) {
                if (node.isVisited()) continue;

                while (!stack.isEmpty()) {
                    // get the current node;
                    GraphNode current = stack.pop();
                    current.setVisited(true);
                    reachableNodes++;
                    System.out.print(current.getData() + " => ");

                    List<GraphNode> currentNeighbours = current.getAllNeighbours();
                    for (GraphNode neighbour : currentNeighbours) {
                        if (neighbour.isVisited()) continue;
                        stack.push(neighbour);
                    }
                }
            }

            markAllNodesUnvisited();
            return reachableNodes;
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

        graph.getMotherVertex();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.execute();
    }
}