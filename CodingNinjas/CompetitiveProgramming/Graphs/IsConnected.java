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

    public boolean breadthFirstSearch(int s) {
        boolean [] visited = new boolean [this.V];

        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        int count = 0;
        while (queue.size() != 0) {
            s = queue.poll();
            count++;
            Iterator<Integer> iter = adjList[s].listIterator();
            while(iter.hasNext()) {
                int n = iter.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return count == this.V;
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
        
        System.out.println(graph.breadthFirstSearch(0));
    }
}
