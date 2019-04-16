class Solution {
    public int combinationSum4(int[] nums, int target) {
        int [] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return combinationSum4Util(nums, target, dp);
    }
    
    public int combinationSum4Util(int [] nums, int target, int [] dp) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        
        if (dp[target] != -1) return dp[target];

        int res = 0;
        for (int i = 0; i < nums.length; i++) 
            res += combinationSum4Util(nums, target - nums[i], dp);

        return dp[target] = res;
    }
}
