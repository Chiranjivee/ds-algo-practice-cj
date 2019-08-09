class Solution {
    public int jump(int[] nums) {
        return step(nums, nums.length-1);
    }
    
    private int step(int[] nums, int last) {
        if(last == 0) return 0;
        
        for(int i=0;i<last;i++) {
            if(nums[i]>=last-i) 
                return step(nums, i) + 1;
        }
        
        return 0;
    }
}
