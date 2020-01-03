class PrintMaximumSumIncreasingSubsequence {
    public void printMaxSumIncreasingSubsequence(int [] arr) {
        int [] dp = getMaxSumIncreasingSubsequence(arr);
        printMaxSeq(dp);
    }

    public void printMaxSeq(int [] arr) {
        int idx = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == idx) {
                System.out.println(arr[i]);
                idx++;
            }
        }
    }

    public int[] getMaxSumIncreasingSubsequence(int [] arr) {

        int [] maxSumSubseq = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            maxSumSubseq[i] = arr[i];
        }
        
        // calculate lis from left
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && maxSumSubseq[i] < maxSumSubseq[j] + arr[i]) {
                    maxSumSubseq[i] = maxSumSubseq[j] + arr[j];
                }
            }
        }

        return maxSumSubseq;
    }
}