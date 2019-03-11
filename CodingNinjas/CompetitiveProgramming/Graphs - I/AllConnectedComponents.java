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
        if (visited[s]) return;
        Stack<Integer> stack = new Stack<>();
        visited[s] = true;
        stack.push(s);
        int count = 0;
        while (stack.size() != 0) {
            s = stack.pop();
            path.add(s);
            for (int i = 0; i < V; i++) {
                if (i == s) continue;
                if (adjMat[s][i] == 1) {
                    if (!visited[i]) {
                        visited[i] = true;
                        stack.push(i);
                    }
                }
            }
        }
        System.out.println();
    }
}

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
        Graph graph = new Graph(V);
		int E = s.nextInt();

        while (E-- > 0) {
            graph.addEdge(s.nextInt(), s.nextInt());
        }
        
        boolean [] visited = new boolean [V];
        for (int i = 0; i < V; i++) {
            List<Integer> list = new ArrayList<>();
            graph.dfs(i, visited, list);
            Collections.sort(list);
            for (Integer e : list) {
                System.out.print(e + " ");
            }
        }
    }
}
