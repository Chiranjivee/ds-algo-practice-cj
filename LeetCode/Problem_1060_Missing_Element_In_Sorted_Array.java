class Solution {
    int missing(int idx, int[] nums) {
        return nums[idx] - nums[0] - idx;
    }

    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        // If kth missing number is larger than 
        // the last element of the array
        if (k > missing(n - 1, nums))
          return nums[n - 1] + k - missing(n - 1, nums);

        int idx = 1;
        // find idx such that 
        // missing(idx - 1) < k <= missing(idx)
        while (missing(idx, nums) < k) idx++;

        // kth missing number is larger than nums[idx - 1]
        // and smaller than nums[idx]
        return nums[idx - 1] + k - missing(idx - 1, nums);
    }
}
