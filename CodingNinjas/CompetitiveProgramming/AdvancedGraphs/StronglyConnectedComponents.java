import java.util.*;

class StronglyConnectedComponents {
    public static void main (String[] args) {
        int n = 10;
        Graph graph = new Graph(n);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        graph.addEdge(2, 4);

        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);

        graph.addEdge(7, 6);
        graph.addEdge(7, 8);
        graph.addEdge(8, 7);

        graph.addEdge(8, 9);

        boolean [] visited = new boolean[n];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            graph.dfs(visited, i, st);
        }

        visited = new boolean[n];
        graph.transpose();
        while (!st.isEmpty()) {
            int curr = st.pop();
            if (!visited[curr]) {
                graph.dfs(visited, curr);
                System.out.println();
            }
        }
    }
}

class Graph {
    int n;
    LinkedList<Integer>[] adjList;

    public Graph (int n) {
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

    public void dfs(boolean [] visited, int source, Stack<Integer> st) {
        if (visited[source]) {
            return;
        }

        visited[source] = true;
        for (Integer neighbour: this.adjList[source]) {
            if (!visited[neighbour]) {
                dfs(visited, neighbour, st);
            }
        }

        st.push(source);
    }

    public void dfs(boolean [] visited, int source) {
        if (visited[source]) {
            return;
        }

        visited[source] = true;
        for (Integer neighbour: this.adjList[source]) {
            if (!visited[neighbour]) {
                dfs(visited, neighbour);
            }
        }
        System.out.print(source + " ");
        // st.push(source);
    }
}
