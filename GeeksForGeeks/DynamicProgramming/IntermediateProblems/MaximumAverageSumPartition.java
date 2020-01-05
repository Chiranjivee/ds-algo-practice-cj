class MaximumAverageSumPartition {
    public static double largestSumOfAverages(int [] arr, int k, int idx) {

        if (idx == arr.length) {
            return 0;
        }

        if (k == 1) {
            int remainingSum = getArraySumFromStartIdxToEnd(arr, idx);
            return remainingSum / (arr.length - idx);
        }

        int sum = 0;
        int result = Integer.MIN_VALUE;
        for (int i = idx + 1; i < arr.length; i++) {
            sum += arr[i];
            result = Math.max(result, largestSumOfAverages(arr, k - 1, i + 1) + sum / (i - idx));
        }

        return result;
    }
}
