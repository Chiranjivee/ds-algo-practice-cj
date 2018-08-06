import java.util.Iterator;
import java.util.LinkedList;

class Graph {
    private int V;
    private LinkedList<Integer>[] adjList;

    public Graph(int v) {
        this.V = v;
        this.adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            this.adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        this.adjList[u].add(v);
    }

    public void breadthFirstSearch(int s) {
        boolean [] visited = new boolean [this.V];

        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> iter = adjList[s].listIterator();
            while(iter.hasNext()) {
                int n = iter.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.breadthFirstSearch(2);
    }
}
