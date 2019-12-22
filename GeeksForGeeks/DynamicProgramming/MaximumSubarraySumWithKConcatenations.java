class MaxSubArraySumWithKConcatenations {
    public int getSum(int [] arr, int k) {

        int bestPrefixSum = getBestPrefixSum(arr);
        int bestSuffixSum = getBestSuffixSum(arr);

        int bestSubArraySum = getSubArraySumByKadanes(arr);
        int getFullArraySum = getFullArraySum(arr);

        int optionOne = bestSubArraySum;
        int optionTwo = getFullArraySum * k;
        int optionThree = bestSuffixSum + getFullArraySum * (k - 2) + bestPrefixSum;

        return Math.max(optionOne, Math.max(optionTwo, optionThree));
    }

    public int getSubArraySumByKadanes(int [] arr) {

        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + arr[i], 0);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public int getFullArraySum(int [] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return sum;
    }


    public int getBestPrefixSum(int [] arr) {
        int sum = 0;
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            prefixSum = Math.max(prefixSum, sum);
        }

        return prefixSum;
    }

    public int getBestSuffixSum(int [] arr) {
        int sum = 0;
        int suffixSum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum += arr[i];
            suffixSum = Math.max(suffixSum, sum);
        }

        return suffixSum;
    }
}
