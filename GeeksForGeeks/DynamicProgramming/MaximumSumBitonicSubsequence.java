class MaximumSumBitonicSubSequence {
    public int getMaximumSumBitonicSubsequence(int [] arr) {

        int [] MSBSF = new int[arr.length + 1];
        int [] MSBSB = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            MSBSF[i] = arr[i];
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

        // calculate lis from right
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && MFBSB[i] < MSBSB[j] + arr[i]) {
                    MSBSB[i] = MSBSB[j] + arr[i];
                }
            }
        }

        // calculate the max lis.
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, MSBSF[i] + MSBSF[i] - arr[i]);
        }

        return max;
    }
}
