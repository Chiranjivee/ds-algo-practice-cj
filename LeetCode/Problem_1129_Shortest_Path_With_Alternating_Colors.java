class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        List<List<Integer>> redList = new ArrayList<>();
        List<List<Integer>> blueList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            redList.add(new ArrayList<>());
            blueList.add(new ArrayList<>());
        }

        for (int[] redEdge : red_edges) {
            redList.get(redEdge[0]).add(redEdge[1]);
        }

        for (int[] blueEdge : blue_edges) {
            blueList.get(blueEdge[0]).add(blueEdge[1]);
        }
        
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(0, 0));
        queue.offer(Arrays.asList(0, 1));

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        
        boolean[][] visited = new boolean[n][2];
        int num = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> pointNode = queue.poll();
                int point = pointNode.get(0);
                int color = pointNode.get(1);
                if (color == 0) {
                    // red
                    List<Integer> edges = blueList.get(point);
                    for (int edge : edges) {
                        if (visited[edge][1]) {
                            continue;
                        }
                        result[edge] = Math.min(result[edge], num + 1);
                        queue.offer(Arrays.asList(edge, 1));
                        visited[edge][1] = true;
                    }
                } else {
                   List<Integer> edges = redList.get(point);
                    for (int edge : edges) {
                        if (visited[edge][0]) {
                            continue;
                        }
                        result[edge] = Math.min(result[edge], num + 1);
                        queue.offer(Arrays.asList(edge, 0));
                        visited[edge][0] = true;
                    } 
                }
            }
            num++;
        }

        result[0] = 0;
        for (int i = 1; i < result.length; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }

        return result; 
    }
}
