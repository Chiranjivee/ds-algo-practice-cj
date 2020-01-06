class Solution {
	static void dfs(int node, int parent, Vector < Integer > tree[], int colour[], int answer[]) {
		// Initial min difference is 
		// the color of node 
		answer[node] = colour[node];

		// Traversing its children 
		for (Integer u: tree[node]) {

			// Not traversing the parent 
			if (u == parent) continue;

			dfs(u, node, tree, colour, answer);

			// If the child is adding positively to 
			// difference, we include it in the answer 
			// Otherwise, we leave the sub-tree and  
			// include 0 (nothing) in the answer 
			answer[node] += Math.max(answer[u], 0);
		}
	}

	static int maxDiff(Vector < Integer > tree[], int colour[], int N) {
		int[] answer = new int[N + 1];

		// DFS for colour difference : 1colour - 2colour 
		dfs(1, 0, tree, colour, answer);

		// Minimum colour difference is  
		// maximum answer value 
		int high = 0;
		for (int i = 1; i <= N; i++) {
			high = Math.max(high, answer[i]);

			// Clearing the current value 
			// to check for colour2 as well 
			answer[i] = 0;
		}

		// Interchanging the colours 
		for (int i = 1; i <= N; i++) {
			if (colour[i] == -1) colour[i] = 1;
			else colour[i] = -1;
		}

		// DFS for colour difference : 2colour - 1colour 
		dfs(1, 0, tree, colour, answer);

		// Checking if colour2 makes the  
		// minimum colour difference 
		for (int i = 1; i < N; i++)
		high = Math.max(high, answer[i]);

		return high;
	}

	// Driver code 
	public static void main(String[] args) {

		// Nodes 
		int N = 5;

		// Adjacency list representation 
		Vector < Integer > tree[] = new Vector[N + 1];
		for (int i = 0; i < N + 1; i++)
		tree[i] = new Vector < Integer > ();

		// Edges 
		tree[1].add(2);
		tree[2].add(1);

		tree[1].add(3);
		tree[3].add(1);

		tree[2].add(4);
		tree[4].add(2);

		tree[3].add(5);
		tree[5].add(3);

		// Index represent the colour of that node 
		// There is no Node 0, so we start from  
		// index 1 to N 
		int colour[] = {
			0,
			1,
			1,
			-1,
			-1,
			1
		};

		// Printing the result 
		System.out.println(maxDiff(tree, colour, N));
	}
}