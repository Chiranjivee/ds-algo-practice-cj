import java.util.Arrays;

class LongestAlternatingSubarrayAtEveryIndex {

    public int solve(int [] arr) {
        int [] dp = new int[arr.length];
        dp[arr.length - 1] = 1;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] * arr[i + 1] < 0) {
                dp[i] = dp[i + 1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        System.out.println(Arrays.toString(dp));
    }
}
