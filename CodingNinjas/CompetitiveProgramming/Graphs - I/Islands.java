import java.util.*;

import java.util.Iterator;
import java.util.LinkedList;

class Graph {
    private int V;
    int[][] adjMat;

    public Graph(int v) {
        this.V = v;
        this.adjMat = new int[V][V];
    }

    public void addEdge(int u, int v) {
        this.adjMat[u][v] = 1;
        this.adjMat[v][u] = 1;
    }

    public void dfs(int s, boolean[] visited, List<Integer> path) {
        if (visited[s])
            return;
        Stack<Integer> stack = new Stack<>();
        visited[s] = true;
        stack.push(s);
        int count = 0;
        while (stack.size() != 0) {
            s = stack.pop();
            path.add(s);
            for (int i = 0; i < V; i++) {
                if (i == s)
                    continue;
                if (adjMat[s][i] == 1) {
                    if (!visited[i]) {
                        visited[i] = true;
                        stack.push(i);
                    }
                }
            }
        }
    }
}

public class solution {
    public int solve(int n, int m, int U[], int V[]) {
        Graph graph = new Graph(n);
        for (int i = 0; i < m; i++) {
            graph.addEdge(U[i] - 1, V[i] - 1);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            graph.dfs(i, visited, list);
            if (list.size() != 0) {
                count++;
            }
        }
        return count;
    }
}
