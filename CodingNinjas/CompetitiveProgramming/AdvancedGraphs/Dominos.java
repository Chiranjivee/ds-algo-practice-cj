import java.util.*;

public class Main {
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

            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < n; i++) {
                graph.dfs(visited, i, st);
            }
            
            visited = new boolean[n];
            int count = 0;
            while (!st.isEmpty()) {
                Integer i = st.pop();
                if (!visited[i]) {
                    graph.dfs(visited, i);
                    count++;
                }
            }
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

    public void transpose() {
        LinkedList<Integer>[] transposedList = new LinkedList[this.n];
        for (int i = 0; i < n; i++) {
            transposedList[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < this.adjList.length; i++) {
            LinkedList<Integer> neighbours = this.adjList[i];
            for (Integer e : neighbours) {
                transposedList[e].add(i);
            }
        }

        this.adjList = transposedList;
    }

    public void dfs(boolean[] visited, int source, Stack<Integer> st) {
        if (visited[source]) {
            return;
        }

        visited[source] = true;
        for (Integer neighbour : this.adjList[source]) {
            if (!visited[neighbour]) {
                dfs(visited, neighbour, st);
            }
        }

        st.push(source);
    }

    public void dfs(boolean[] visited, int source) {
        if (visited[source]) {
            return;
        }

        visited[source] = true;
        for (Integer neighbour : this.adjList[source]) {
            if (!visited[neighbour]) {
                dfs(visited, neighbour);
            }
        }
    }
}
