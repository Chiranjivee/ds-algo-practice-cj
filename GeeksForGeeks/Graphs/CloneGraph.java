class CloneGraph {

    HashMap<GraphNode, GraphNode> map = new HashMap<>();

    // undirected connecteed graph
    public GraphNode clone(GraphNode node) {

        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        GraphNode clonedNode = new GraphNode(node.val);
        for (GraphNode neighbour: node) {
            Node clonedNeighbour = clone(neighbour);
            clonedNode.neighbours.add(clonedNeighbour);
        }

        return  clonedNode;
    }
}
