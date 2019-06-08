class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        for (int [] preq : prerequisites) {
            graph.addEdge(preq[0], preq[1]);
        }
        return !graph.hasCycle();
    }
}


class Graph {    
    int [][] adjMatrix;

    Graph(int x) {
        this.adjMatrix = new int[x][x];
    }
    
    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
    }

    public boolean hasCycle() {
        boolean [] beingProcessed = new boolean[adjMatrix.length];
        boolean [] visited = new boolean[adjMatrix.length];
        
        for (int i = 0; i < adjMatrix.length; i++) {
            if (dfsUtil(i, beingProcessed, visited)) {
                return true;
            }
        }

        return false;
    }
    
    public boolean dfsUtil(int source, boolean [] beingProcessed, boolean [] visited) {
        if (beingProcessed[source]) {
            return true;
        }
        
        if (visited[source]) return false;
        
        visited[source] = true;
        beingProcessed[source] = true;
        
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[source][i] == 1) {
                if (dfsUtil(i, beingProcessed, visited)) {
                    return true;
                }
            }
        }
        beingProcessed[source] = false;
        return false;        
    }
}
