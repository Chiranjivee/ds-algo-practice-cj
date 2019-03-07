import java.util.*;

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
        this.adjList[v].add(u);
    }

    public void breadthFirstSearch(int s) {
        for (int i = 0; i < V; i++) {
            Collections.sort(this.adjList[i]);
        }
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
        graph.breadthFirstSearch(0);
    }
}
