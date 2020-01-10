class MaximumSubarraySum {
    public int findMaxSubarraySum(int [] arr, int left, int right) {

        if (left == right) {
            return arr[left];
        }

        int mid = (left + right) / 2;
        int leftSum = findMaxSubarraySum(arr, left, mid);
        int rightSum = findMaxSubarraySum(arr, mid + 1, right);

        int crossingSum = findCrossingSum(arr, left, mid, right);
    }

    private int findCrossingSum(int [] arr, int left, int mid, int right) {
        int leftSum = 0;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        int rightSum = 0;
        for (int j = mid + 1; j <= right; j++) {
            sum += arr[j];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }
}
