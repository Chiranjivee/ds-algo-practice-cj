class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray subarray = new MaximumSubarray();
        // int ans = subarray.maxSubArray(new int [] {-2,1,-3,4,-1,2,1,-5,4});
        int ans = subarray.maxSubArray(new int [] {-3, 4, -1, 2, 1, -5});
        System.out.println(ans);

    }

    public int maxSubArray(int[] nums) {        
        return maxSubArrayUtil(nums, 0, nums.length - 1);
    }

    public int maxSubArrayUtil(int [] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        
        int mid = (start + end) / 2;
        
        int option1 = maxSubArrayUtil(nums, start, mid);
        int option2 = maxSubArrayUtil(nums, mid + 1, end);
        
        int option3 = maxSubArrayCrossingSum(nums, start, mid, end);
        return Math.max(option1, Math.max(option2, option3));
    }

    public int maxSubArrayCrossingSum(int[] nums, int start, int mid, int end) {
        int leftSum = Integer.MIN_VALUE;

        int tempSum = 0;
        for (int i = mid; i >= start; i--) {
            tempSum += nums[i];
            leftSum = Math.max(leftSum, tempSum);
        }

        int rightSum = Integer.MIN_VALUE;
        tempSum = 0;
        for (int i = mid + 1; i <= end; i++) {
            tempSum += nums[i];
            rightSum = Math.max(rightSum, tempSum);
        }
        return leftSum + rightSum;
    }
}

