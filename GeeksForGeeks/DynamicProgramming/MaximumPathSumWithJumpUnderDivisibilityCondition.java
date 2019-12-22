import java.util.Arrays;

class MaximumPathSumWithJumpUnderDivisibilityCondition {
    public int printMaxSum(int [] arr) {
        int [] dp = new int[arr.length];



        for (int i = 0; i < arr.length; i++) {

            dp[i] = arr[i];

            int position = i + 1;
            int max = 0;
            for (int j = 1; j <= Math.sqrt(position); i++) {

                max = Math.max(max, dp[j - 1]);

                if (dp[position / j - 1] > max && j != 1) {
                    max = dp[position / j - 1]
                }
            }

            dp[i] += max;
        }

        System.out.println(Arrays.toString(dp));
    }
}