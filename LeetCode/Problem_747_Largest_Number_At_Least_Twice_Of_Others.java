class Solution {
    public int dominantIndex(int[] nums) {
        int maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[maxIdx] < nums[i]) {
                maxIdx = i;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i == maxIdx) continue;
            
            if (nums[i] * 2 > nums[maxIdx]) {
                return -1;
            }
        }
        return maxIdx;
    }
}
