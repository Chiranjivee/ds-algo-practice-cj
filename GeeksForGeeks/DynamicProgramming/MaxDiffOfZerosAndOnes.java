class MaxDiffOfZeroesAndOnesInBinaryString {
    public int getMaxSubarrayWith0And1MaxDiff(String str) {

        int [] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0' == 0 ? 1 : -1;
        }

        // find the max subarray with max sum
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i] + maxEndingHere, 0);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}