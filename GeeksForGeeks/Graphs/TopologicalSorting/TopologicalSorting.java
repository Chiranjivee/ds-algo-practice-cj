class TopologicalSorting {
    void topologicalSortUtil(int v, boolean visited[], Stack stack) {
        // Mark the current node as visited. 
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Push current vertex to stack which stores result 
        stack.push(new Integer(v));
    }

    // The function to do Topological Sort. It uses 
    // recursive topologicalSortUtil() 
    void topologicalSort() {
        Stack stack = new Stack();

        // Mark all the vertices as not visited 
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Call the recursive helper function to store 
        // Topological Sort starting from all vertices 
        // one by one 
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack 
        while (stack.empty() == false)
            System.out.print(stack.pop() + " ");
    }
}
