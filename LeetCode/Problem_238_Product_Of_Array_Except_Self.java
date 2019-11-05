class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length - 1;
        int [] res = new int[n + 1];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        int right = 1;
        for (int i = n; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
