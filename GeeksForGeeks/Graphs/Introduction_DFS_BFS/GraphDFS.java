class GraphBFS {
    public void doDFS(Graph g, int s) {
        boolean [] visited = new booelan[g.noOfV];
        doDFSUtil(g, s, visited);
    }
    public void doDFSUtil(Graph g, int s, boolean [] visited) {

        if (visited[s]) {
            return;
        }

        visited[s] = true;
        System.out.println(s);

        LinkedList<Integer> neighbours = g.adjList[current];
        for (int neighbour : neighbours) {
            if (!visited[neighbour])
                doDFSUtil(g, neighbour, visited);
        }
    }
}

class Graph {
    int noOfV;
    LinkedList<Integer> [] adjList;
}
