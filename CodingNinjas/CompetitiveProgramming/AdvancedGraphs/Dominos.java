import java.util.*;

public class Dominoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();

            Graph graph = new Graph(n);
            for (int i = 0; i < q; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                graph.addEdge(u - 1, v - 1);
            }

            boolean[] visited = new boolean[n];
            int[] depth = new int[n];

            Stack<Integer> st = new Stack<>();
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    depth[i] = graph.dfs(visited, i, depth);
                    count++;
                }
            }

            System.out.println(Arrays.toString(depth));
            System.out.println(count);
        }
    }
}

class Graph {
    int n;
    LinkedList<Integer>[] adjList;

    public Graph(int n) {
        this.n = n;
        this.adjList = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            this.adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int u, int v) {
        this.adjList[u].add(v);
    }

    public int dfs(boolean[] visited, int source, int[] depth) {
        if (visited[source]) {
            return depth[source];
        }

        int currDepth = 1;
        visited[source] = true;

        for (Integer neighbour : this.adjList[source]) {
            if (!visited[neighbour]) {
                currDepth += dfs(visited, neighbour, depth);
            }
        }
        return currDepth;
    }
}
