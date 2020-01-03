class LongestCommonIncreasingSubsequence {
    // assuming arr2 will be of greater length
    public int findLongestCommonIncreasingSubsequence(int [] arr, int [] arr2) {

        // length of lcs ending at arr2[i] 
        int [] dp = new int[arr2.length];

        for (int i = 0; i < arr.length; i++) {
            int current = 0;
            for (int j = 0; j < arr2.length; j++) {

                if (arr[i] == arr2[j]) {
                    if (current + 1 > dp[j]) {
                        dp[j] = current + 1;
                    }
                }

                if (arr[i] > arr[j]) {
                    if (table[j] > current) {
                        current = table[j];
                    }
                }
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
