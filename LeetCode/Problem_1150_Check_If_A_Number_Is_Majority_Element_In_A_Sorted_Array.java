class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int low = 0,high = nums.length-1,mid = 0;
        int highest = -1,lowest = -1;
        
        
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] == target){
                highest = mid;
                low = mid + 1;
            }else if(nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        
        if(highest == -1) return false;
        
        low = 0;high = nums.length-1;
        
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] == target){
                lowest = mid;
                high = mid - 1;
            }else if(nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        
        return highest - lowest + 1 > nums.length / 2;
    }
}
