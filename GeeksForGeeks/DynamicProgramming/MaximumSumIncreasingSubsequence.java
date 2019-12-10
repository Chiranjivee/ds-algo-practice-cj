class MaximumSumIncreasingSubsequence {
    public int getMaximumSumBitonicSubsequence(int [] arr) {

        int [] MSBSF = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            MSBSF[i] = arr[i];
        }
        
        // calculate lis from left
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && MSBSF[i] < MSBSF[j] + arr[i]) {
                    MSBSF[i] = MSBSF[j] + arr[j];
                }
            }
        }

        // calculate the max lis.
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, MSBSF[i]);
        }

        return max;
    }
}
