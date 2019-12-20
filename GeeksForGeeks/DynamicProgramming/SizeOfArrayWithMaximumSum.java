class SizeOfArrayWithMaximumSum {

    public int getSizeOfArrayWithMaximumSum(int [] arr) {
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;

        int start = 0; int end = 0;
        int s = 0;

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + arr[i], 0);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            if (maxSoFar < maxEndingHere) {
                start = s;
                end = i;
            }

            if (maxEndingHere == 0) {
                s = i + 1;
            }
        }

        // All negatives the size is 1
        if (maxEndingHere = 0) {
            return 1;
        }

        return end - start + 1;
    }

    public int findMaximumSumSubarray(int [] arr) {
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;
        int maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + arr[i], 0);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            maxElement = Math.max(maxElement, arr[i]);
        }

        if (maxEndingHere = 0) {
            return maxElement;
        }

        return maxSoFar;
    }

    public static void main(String [] args) {

    }
}