class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int N = edges.length;
        Map<Integer, Integer> parent = new HashMap();
        List<int[]> candidates = new ArrayList();
        for (int[] edge: edges) {
            if (parent.containsKey(edge[1])) {
                candidates.add(new int[]{parent.get(edge[1]), edge[1]});
                candidates.add(edge);
            } else {
                parent.put(edge[1], edge[0]);
            }
        }

        int root = orbit(1, parent).node;
        if (candidates.isEmpty()) {
            Set<Integer> cycle = orbit(root, parent).seen;
            int[] ans = new int[]{0, 0};
            for (int[] edge: edges) {
                if (cycle.contains(edge[0]) && cycle.contains(edge[1])) {
                    ans = edge;
                }
            }
            return ans;
        }

        Map<Integer, List<Integer>> children = new HashMap();
        for (int v: parent.keySet()) {
            int pv = parent.get(v);
            if (!children.containsKey(pv))
                children.put(pv, new ArrayList<Integer>());
            children.get(pv).add(v);
        }

        boolean[] seen = new boolean[N+1];
        seen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.add(root);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!seen[node]) {
                seen[node] = true;
                if (children.containsKey(node)) {
                    for (int c: children.get(node))
                        stack.push(c);
                }
            }
        }
        for (boolean b: seen) if (!b)
            return candidates.get(0);
        return candidates.get(1);
    }

    public OrbitResult orbit(int node, Map<Integer, Integer> parent) {
        Set<Integer> seen = new HashSet();
        while (parent.containsKey(node) && !seen.contains(node)) {
            seen.add(node);
            node = parent.get(node);
        }
        return new OrbitResult(node, seen);
    }

}
class OrbitResult {
    int node;
    Set<Integer> seen;
    OrbitResult(int n, Set<Integer> s) {
        node = n;
        seen = s;
    }
}
