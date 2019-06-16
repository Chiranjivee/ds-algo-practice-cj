class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int[] item : items) {

            int id = item[0];
            int score = item[1];

            map.putIfAbsent(id, new PriorityQueue<>(5));
            PriorityQueue<Integer> scores = map.get(id);

            if (scores.size() < 5) {
                scores.offer(score);
            } else if (scores.peek() < score) {
                scores.poll();
                scores.offer(score);
            }
        }

        int[][] result = new int[map.size()][2];
        int cur = 0;

        for (int i = 1; i <= 1000; ++i) {
            PriorityQueue<Integer> scores = map.get(i);
            if (scores == null) {
                continue;
            }

            int sum = 0;
            while (!scores.isEmpty()) {
                sum += scores.poll();
            }

            result[cur][0] = i;
            result[cur][1] = sum / 5;
            cur++;
        }

        return result;
    }
}
