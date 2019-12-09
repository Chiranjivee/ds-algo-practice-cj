class LongestBitonicSubsequence {
    public int findLongestBitonicSubsequenceLength(int [] arr) {
        // The idea is to find lis from start and end and then add

        int [] lis = new int[arr.length];
        Arrays.fill(lis, 1);
        int [] lds = new int[arr.length];
        Arrays.fill(lds, 1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }

                if (arr[i] < arr[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        int max = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, lis[i] + lis[j] - 1);
        }

        return max;
    }
}