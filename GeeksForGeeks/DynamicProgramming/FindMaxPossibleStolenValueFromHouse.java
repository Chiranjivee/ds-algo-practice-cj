class FindMaxStolenValueFromHouse {
    public int getMaxStolen(int [] arr) {

        int [] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[arr.length - 1];
    }
}