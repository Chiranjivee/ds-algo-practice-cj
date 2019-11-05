import java.util.*;

public class Bottom {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            Graph graph = new Graph(n);

            int e = sc.nextInt();
            while (e-- > 0) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.addEdge(u - 1, v - 1);
            }

            Stack<Integer> st = new Stack<>();
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                graph.dfs(visited, i, st);
            }

            graph.transpose();

            int[] component = new int[n];
            visited = new boolean[n];
            int componentId = 0;
            while (!st.isEmpty()) {
                int node = st.pop();
                if (!visited[node]) {
                    componentId++;
                    List<Integer> list = new ArrayList<>();
                    graph.dfs(visited, node, list);
                    for (Integer ed : list) {
                        component[ed] = componentId;
                    }
                }
            }

            graph.transpose();

            int[] bottom = new int[n];
            for (int i = 0; i < n; i++) {
                LinkedList<Integer> edges = graph.getEdges(i);
                for (Integer ed : edges) {
                    if (component[i] != component[ed]) {
                        int comp = component[i];
                        for (int c = 0; c < n; c++) {
                            if (comp == component[c]) {
                                bottom[c] = -1;
                            }
                        }

                        break;
                    }
                }
            }

            for (int i = 0; i < bottom.length; i++) {
                if (bottom[i] == -1)
                    continue;
                System.out.print((i + 1) + " ");
            }
            System.out.println();
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

    public LinkedList<Integer> getEdges(int u) {
        return this.adjList[u];
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

    public void dfs(boolean[] visited, int source, List<Integer> list) {
        if (visited[source]) {
            return;
        }

        visited[source] = true;
        for (Integer neighbour : this.adjList[source]) {
            if (!visited[neighbour]) {
                dfs(visited, neighbour, list);
            }
        }
        list.add(source);
    }
}
