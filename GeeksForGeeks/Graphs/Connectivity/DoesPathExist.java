import java.io.*;
import java.util.*;
import java.util.LinkedList;

class Graph {
	private int V; // No. of vertices 
	private LinkedList<Integer> adj[]; //Adjacency List 

	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i<v; ++i)
			adj[i] = new LinkedList();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	//prints BFS traversal from a given source s 
	Boolean isReachable(int s, int d) {
		LinkedList<Integer> temp;

		// Mark all the vertices as not visited(By default set 
		// as false) 
		boolean visited[] = new boolean[V];

		// Create a queue for BFS 
		LinkedList<Integer> queue = new LinkedList<Integer> ();

		// Mark the current node as visited and enqueue it 
		visited[s] = true;
		queue.add(s);

		// 'i' will be used to get all adjacent vertices of a vertex 
		Iterator<Integer> i;
		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it 
			s = queue.poll();

			int n;
			i = adj[s].listIterator();

			while (i.hasNext()) {
				n = i.next();

				// If this adjacent node is the destination node, 
				// then return true 
				if (n == d)
					return true;

				// Else, continue to do BFS 
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}

		return false;
    }
}
