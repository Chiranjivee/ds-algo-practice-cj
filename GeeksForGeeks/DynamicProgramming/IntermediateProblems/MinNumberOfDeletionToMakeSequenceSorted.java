class MinNumberOfDeletionsToMakeSeqSorted {
    public int solve(int [] arr) {
        int lis = getLisLength(arr);
        return arr.length - lis;
    }

    public int getLisLength(int [] arr) {

        int [] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = 1 + lis[j];
                }
            }
        }

        int res = dp[0];
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
