class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int [] temp = Arrays.copyOf(nums, nums.length);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(temp));
        
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        
        while (start < nums.length && nums[start] == temp[start]) {
            start++;
        }
        
        while (end >= 0 && nums[end] == temp[end]) {
            end--;
        }
        
        return end > start ? end - start + 1: 0;
    }
}
