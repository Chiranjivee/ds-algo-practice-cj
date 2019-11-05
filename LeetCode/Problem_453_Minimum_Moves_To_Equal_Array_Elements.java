class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            sum += nums[i];
        }
        return sum - min * nums.length;
    }
}
