import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Graph graph = new Graph(n);
            while (m-- > 0) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.addEdge(u - 1, v - 1);
            }
            int [] bananas = new int[n];
            for (int i = 0; i < n; i++) {
                bananas[i] = sc.nextInt();
            }

            long res = 0;
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    long temp = graph.breadthFirstSearch(i, visited, bananas);
                    res = Math.max(temp, res);
                }
            }
            
            System.out.println(res);
        }
	}
}

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
        this.adjList[v].add(u);
    }
    
    public LinkedList<Integer> getEdges(int s) {
        return this.adjList[s];
    }

    public long breadthFirstSearch(int s, boolean[] visited, int [] bananas) {
        
        visited[s] = true;
        long res = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            res += bananas[s];
            Iterator<Integer> iter = adjList[s].listIterator();
            while (iter.hasNext()) {
                int n = iter.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        return res;
    }
}
