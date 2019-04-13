class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int max = nums[0];
        for (int i = 0; i < nums.length; i++) 
            max = Math.max(max, nums[i]);

        int [] count = new int[max + 1];
        for (int i = 0; i < nums.length; i++)
            count[nums[i]]++;

        int res = 0;
        int [] dp = new int[max + 1];
        
        dp[0] = 0;
        dp[1] = count[1];
        for (int i = 2; i < count.length; i++) {
            if (count[i] == 0) {
                dp[i] = dp[i - 1];
                continue;
            }
            
            int option1 = count[i] * i + dp[i - 2];
            int option2 = dp[i - 1];
            
            dp[i] = Math.max(option1, option2);
        }
        
        return dp[count.length - 1];
    }
}
