import java.util.Arrays;

class MaximumLengthSubsequenceWithDifferenceZeroOrOne {

    public static int maxLengthSubsequenceWithDifferenceZeroOrOne(int [] arr) {

        int [] dp = new int[arr.length + 1];
        Arrays.fill(dp, 1);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(arr[i] - arr[j]) <= 1 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
