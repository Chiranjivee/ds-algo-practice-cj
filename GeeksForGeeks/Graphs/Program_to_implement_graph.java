class Solution {
    class GraphNode {
        int data;
        List<GraphNode> neighbours;

        public GraphNode(int data) {
            this.data = data;
            this.neighbours = new ArrayList<>();
        }

        public int getData() {
            return this.data;
        }

        public void addNeighbour(GraphNode g) {
            this.neighbours.add(g);
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

        graph.add(g1);
        graph.add(g2);
        graph.add(g3);
        graph.add(g4);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.execute();
    }
}