class StronglyConnectedComponents {

    public static void main (String[] args) {

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
            this.transposedList[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < this.adjList.length; i++) {
            LinkedList<Integer> neighbours = this.adjList[i];
            for (Integer e : neighbours) {
                this.transposedList[e].add(i);
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
                dfs(visited, neighbour);
            }
        }

        st.push(source);
        System.out.print(source + " ");
    }
}
