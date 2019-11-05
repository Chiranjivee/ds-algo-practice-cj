class Solution {
    public int minimumCost(int N, int[][] connections) {
        int [] cities = new int[N];
        Arrays.fill(cities, -1);
        
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        DSU disjointSet = new DSU(N);
        for (int [] connection : connections) {
            disjointSet.union(connection[0] - 1, connection[1] - 1, connection[2]);
        }
        
        if (!disjointSet.isConnected()) {
            return -1;
        }
        
        return disjointSet.getRes();
    } 
}

class DSU {
    int [] parent;
    int sum = 0;
    public DSU(int n) {
        this.parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }
        return x;
    }

    public void union(int x, int y, int edgeCost) {
        int pX = find(x);
        int pY = find(y);        
        
        if (pX == pY) {
            return;
        }

        sum += edgeCost;
        parent[pX] = pY;
    }
    
    public boolean isConnected() {
        int components = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                components++;
                if (components > 1) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int getRes() {
        return sum;
    }
}
