import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Problem 4.1
 * 
 * Route Bentween Node: Given a directed graph, design an algorithm to find out whether there is a 
 * route between two nodes.
 * 
 */
class Solution {
    class GraphNode {
        int data;
        boolean isVisited;
        List<GraphNode> neighbours;

        public GraphNode(int data) {
            this.data = data;
            this.neighbours = new ArrayList<>();
        }

        public void setVisited(boolean isVisited) {
            this.isVisited = isVisited;
        }

        public boolean isVisited() {
            return this.isVisited;
        }

        public void addNeighbour(GraphNode neighbour) {
            this.neighbours.add(neighbour);
        }

        public List<GraphNode> getAllNeighbours() {
            return this.neighbours;
        }
    }

    class Graph {
        List<GraphNode> nodes;
        public Graph() {
            this.nodes = new ArrayList<>();
        }

        public void add(GraphNode node) {
            this.nodes.add(node);
        }

        private void markAllNodesUnvisited() {
            // Mark all nodes unvisited;
            for (GraphNode node : this.nodes)
                node.setVisited(false);
        }

        public boolean doesPathExistDFS(GraphNode start, GraphNode des) {
            // Mark all nodes unvisited;
            markAllNodesUnvisited();
            
            Stack<GraphNode> stack = new Stack<>();
            stack.push(start);
            for (GraphNode node : this.nodes) {
                if (node.isVisited()) continue;

                while (!stack.isEmpty()) {
                    // get the current node;
                    GraphNode current = stack.pop();
                    current.setVisited(true);
                    if (current == des) return true;
                    List<GraphNode> currentNeighbours = current.getAllNeighbours();
                    for (GraphNode neighbour : currentNeighbours) {
                        if (neighbour.isVisited()) continue;
                        stack.push(neighbour);
                    }
                }
            }

            markAllNodesUnvisited();
            return false;
        }

        public boolean doesPathExistBFS(GraphNode start, GraphNode des) {
            // Mark all nodes unvisited;
            markAllNodesUnvisited();
            
            Queue<GraphNode> queue = new LinkedList<>();
            queue.add(start);
            for (GraphNode node : this.nodes) {
                if (node.isVisited()) continue;

                while (!queue.isEmpty()) {
                    // get the current node;
                    GraphNode current = queue.remove();
                    current.setVisited(true);
                    if (current == des) return true;
                    List<GraphNode> currentNeighbours = current.getAllNeighbours();
                    for (GraphNode neighbour : currentNeighbours) {
                        if (neighbour.isVisited()) continue;
                        queue.add(neighbour);
                    }
                }
            }

            markAllNodesUnvisited();
            return false;
        }
    }

    public void execute() {
        Graph graph = new Graph();
        GraphNode g1 = new GraphNode(1);
        GraphNode g2 = new GraphNode(2);
        GraphNode g3 = new GraphNode(3);
        GraphNode g4 = new GraphNode(4);
        GraphNode g5 = new GraphNode(5);

        g1.addNeighbour(g2);
        g1.addNeighbour(g3);
        g1.addNeighbour(g4);

        g4.addNeighbour(g5);
        g2.addNeighbour(g3);
        g2.addNeighbour(g4);

        graph.add(g1);
        graph.add(g2);
        graph.add(g3);
        graph.add(g4);
        graph.add(g5);

        System.out.println("Path between 1 & 5: " + graph.doesPathExistDFS(g1, g5));
        System.out.println("Path between 1 & 5: " + graph.doesPathExistBFS(g1, g5));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.execute();
    }
}
