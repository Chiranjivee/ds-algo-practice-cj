class MaximumSubarraySumWithPrefixSum {
    public int getMaxSubarraySum(int [] arr) {
        int [] prefix = getPrefixSum(arr);

        int minPrefixSum = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            result = Math.max(result, prefix[i] - minPrefixSum);
            minPrefixSum = Math.min(minPrefixSum, prefix[i]);
        }

        return res;
    }
}
