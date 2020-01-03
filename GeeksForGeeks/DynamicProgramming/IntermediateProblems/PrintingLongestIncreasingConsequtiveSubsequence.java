class LongestIncreasingConsequtiveSubsequence {
    public int findLongestIncreasingConsequtiveSubsequence(int [] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // max subseq ending at dp[i]
        int [] dp = new int[arr.length];
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < arr.length; i++) {

            if (map.contains(arr[i] - 1)) {
                int lastIdx = map.get(arr[i]);
                dp[i] = 1 + dp[lastIdx];
            } else {
                dp[i] = 1;
            }

            map.put(arr[i], i);
            if (dp[i] > max) {
                max = dp[i];
                idx = i;
            }
        }

        for (int i = curr = arr[idx] - max; curr <= arr[idx]; curr++) {
            System.out.print(curr + " ");
        }
    }
}
