class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(stones.length, (a, b) -> b - a);
        for (int i = 0; i < stones.length; i++) {
            heap.offer(stones[i]);
        }

        while (heap.size() > 1) {
            int largest = heap.poll();
            int secLargest = heap.poll();
            if (largest - secLargest > 0) {
                heap.offer(largest - secLargest);
            }
        }

        return heap.size() == 0 ? 0 : heap.poll();
    }
}
