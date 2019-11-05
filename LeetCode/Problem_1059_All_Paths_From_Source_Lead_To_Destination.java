class Solution {
    enum State { PROCESSING, PROCESSED }
    
    public boolean leadsToDestination(int n, int[][] edges, int src, int dest) {
        List<Integer>[] graph = buildDigraph(n, edges);
        return leadsToDest(graph, src, dest, new State[n]);
    }
    
    private boolean leadsToDest(List<Integer>[] graph, int node, int dest, State[] states) {
        if (states[node] != null) return states[node] == State.PROCESSED;
        if (graph[node].isEmpty()) return node == dest;
        states[node] = State.PROCESSING;
        for (int next : graph[node]) {
            if (!leadsToDest(graph, next, dest, states)) return false;
        }
        states[node] = State.PROCESSED;
        return true;
    }
    
    private List<Integer>[] buildDigraph(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        return graph;
    }
}
