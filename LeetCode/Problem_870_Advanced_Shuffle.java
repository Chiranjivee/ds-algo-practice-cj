class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int[] TJSM = new int[A.length];

        // Sort my hand to have an ordered horse quality
        Arrays.sort(A);

        // Use a max heap for my opponents to deal with his faster horse first
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < B.length; i++) {
            maxHeap.offer(new int[] {i, B[i]});
        }

        int slow = 0, fast = A.length - 1;
        while (!maxHeap.isEmpty()) {
            int[] b = maxHeap.poll();
            // If my fastest horse remained is slower than my opponents' fastest horse,
            // there is no way for me to win, use my slower horse.
            // Otherwise use my fastest horse to win this round.
            // Why using my second fastest horse won't improve my global scores?
            // If my second fastest horse is faster than my opponents' fastest one,
            // it sure is faster than the rest of his horse. Thus proved this strategy is
            // optimal.
            TJSM[b[0]] = b[1] >= A[fast] ? A[slow++] : A[fast--];
        }

        return TJSM;
    }
}
