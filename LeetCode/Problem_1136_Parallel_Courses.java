class Solution {
    public int minimumSemesters(int N, int[][] relations) {
        Map<Integer, List<Integer>> g = new HashMap<>(); // key: prerequisite, value: course list. 
        int[] inDegree = new int[N + 1]; // inDegree[i]: number of prerequisites for i.
        for (int[] r : relations) {
            g.computeIfAbsent(r[0], l -> new ArrayList<>()).add(r[1]); // construct graph.
            ++inDegree[r[1]]; // count prerequisites for r[1].
        }
        Queue<Integer> q = new LinkedList<>(); // save current 0 in-degree vertices.
        for (int i = 1; i <= N; ++i)
            if (inDegree[i] == 0)
                q.offer(i);
        int semester = 0;
        while (!q.isEmpty()) { // BFS traverse all currently 0 in degree vertices.
            for (int sz = q.size(); sz > 0; --sz) { // sz is the search breadth.
                int c = q.poll();
                --N;
                if (!g.containsKey(c)) continue; // c's in-degree is currently 0, but it has no prerequisite.
                for (int course : g.remove(c))
                    if (--inDegree[course] == 0) // decrease the in-degree of course's neighbors.
                        q.offer(course); // add current 0 in-degree vertex into Queue.
            }
            ++semester; // need one more semester.
        }
        return N == 0 ? semester : -1;
    }
}
