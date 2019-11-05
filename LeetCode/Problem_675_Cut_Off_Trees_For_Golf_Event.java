class Solution {
    int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0)
            return -1;
        int steps = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.val - n2.val;
            }
        });
        int m = forest.size();
        int n = forest.get(0).size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.offer(new Node(i, j, forest.get(i).get(j)));
                }
            }
        }
        Node start = new Node(0, 0, forest.get(0).get(0));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int currSteps = bfs(forest, start, curr, m, n, 0);
            if (currSteps == -1)
                return -1;
            steps += currSteps;
            start = curr;
        }

        return steps;
    }

    private int bfs(List<List<Integer>> forest, Node start, Node destination, int rowSize, int colSize, int steps) {
        Queue<Node> queue = new LinkedList<Node>();
        boolean[][] visited = new boolean[rowSize][colSize];
        queue.offer(start);
        visited[start.x][start.y] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (curr.x == destination.x && curr.y == destination.y) {
                    System.out.println("steps returned " + steps);
                    forest.get(destination.x).set(destination.y, 1);
                    return steps;
                }
                for (int[] each : dir) {
                    int tempX = curr.x + each[0];
                    int tempY = curr.y + each[1];
                    if (tempX >= 0 && tempY >= 0 && tempY < colSize && tempX < rowSize && !visited[tempX][tempY]
                            && forest.get(tempX).get(tempY) != 0) {
                        visited[tempX][tempY] = true;
                        queue.offer(new Node(tempX, tempY, forest.get(tempX).get(tempY)));
                    }
                }
            }
            steps += 1;
        }
        return -1;
    }
}

class Node {
    int x;
    int y;
    int val;

    Node(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
