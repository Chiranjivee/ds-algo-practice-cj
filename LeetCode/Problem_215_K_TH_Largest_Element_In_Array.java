class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);
        
        for(int el : nums) {
            pq.add(el);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }
}
