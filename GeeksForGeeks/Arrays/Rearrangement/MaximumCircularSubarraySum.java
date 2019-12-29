class MaximumCircularSubarraySum {
    public int solve(int [] arr) {
        int optionOne = kadane(arr);
        int optionTwo = sumArrayElements(arr);
        invertArrayElements();
        return Math.max(optionOne, optionTwo + kadane(arr));
    }

    public void invertArrayElements(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -arr[i];
        }
    }
    
    public int sumArrayElements(int [] arr) {
        int arrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
        }
        return arrSum;
    }
    
    public int kadane(int [] arr) {
        int n = arr.length;

        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + arr[i], 0);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
