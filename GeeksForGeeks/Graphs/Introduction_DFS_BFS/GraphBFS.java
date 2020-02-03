class GraphBFS {
    public void doBFS(Graph g, int s) {
        boolean [] visited = new boolean[g.noOfV];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println(current);
            visited[current] = true;

            LinkedList<Integer> neighbours = g.adjList[current];
            for (int neighbour : neighbours) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                }
            }
        }
    }
}

class Graph {
    int noOfV;
    LinkedList<Integer> [] adjList;
}
