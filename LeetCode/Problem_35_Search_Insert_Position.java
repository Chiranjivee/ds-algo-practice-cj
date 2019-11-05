class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                ans = mid;
                break;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        // sol will be at start and not end because, 
        // start and end have crossed each other at this point and 
        // start represents that (how many numbers are smaller than
        // the current target)so, the number should be added at start or 
        // some index greater than start. since end will always be 
        // less than start, we take start
        return ans >= 0 ? ans : start;
    }
}
