class CountPossiblePathBetweenTwoVertex {
    static int countPaths = 0;
    public void countPaths(Graph g, int u, int v) {
        boolean [] visited = new boolean[g.getNumberOfNodes()];
        countPathsUtil(g, u, v, visited);
    }

    public void countPathsUtil(Graph g, int src, int  dest, boolean [] visited) {

        visited[src] = true;
        if (src == dest) {
            countPaths++;
        } else { 
            List<Integer> neighbours = g.getNeighbours(src);
            for (int neighbour : neighbours) {
                if (!visited[neighbour]) {
                    countPathsUtil(g, neighbour, dest, visited);
                }
            }
        }

        visited[src] = false;
    }
}
