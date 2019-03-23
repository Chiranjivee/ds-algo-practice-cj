/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
class NumArray {
    int [] prefixSum;
    public NumArray(int[] nums) {
        this.prefixSum = new int[nums.length];
        if (nums.length != 0)
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) return prefixSum[j];
        else return prefixSum[j] - prefixSum[i - 1];
    }
}
