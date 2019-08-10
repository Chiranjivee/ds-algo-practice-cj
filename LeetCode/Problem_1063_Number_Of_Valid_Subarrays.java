class Solution {
    public int validSubarrays(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length, res = 0;
        for(int i = n - 1; i >= 0; --i){
            while(!stack.isEmpty() && nums[i] <= nums[stack.peek()]) stack.pop();
            res += (stack.isEmpty() ? n : stack.peek()) - i;
            stack.push(i);
        }
        return res;
    }
}
