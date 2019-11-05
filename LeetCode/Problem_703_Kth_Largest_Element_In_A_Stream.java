/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
class KthLargest {
    int k;
    PriorityQueue<Integer> queue;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>();
        for (Integer e : nums) {
            queue.add(e);
            if (queue.size() == k + 1) {
                queue.remove();
            }
        }
    }
    
    public int add(int val) {
        this.queue.add(val);
        if (queue.size() == k + 1) {
            queue.remove();
        }
        return queue.peek();
    }
}
