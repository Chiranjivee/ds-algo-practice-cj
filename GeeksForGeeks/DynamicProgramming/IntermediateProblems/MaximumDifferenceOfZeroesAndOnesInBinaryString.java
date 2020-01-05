class MaximumDifferenceOfZeroesAndOnesInBinaryString {
    public int getMaxDiffBetweenZeroesAndOnes(String x) {
        int [] arr = new int[x.length()];
        for (int i = 0; i < x.length(); i++) {
            arr[i] = x.charAt(i) - '0';
        }

        if (isAllOnes(arr)) {
            return -1;
        }

        return kadane(arr);
    }

    public boolean isAllOnes(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return false;
            }
        }

        return true;
    }

    public int kadane(int [] arr) {
        int maxEndingHere = 0;
        int maxSoFar = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + arr[i], 0);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
