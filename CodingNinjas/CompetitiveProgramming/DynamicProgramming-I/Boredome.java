
public class Boredome {
      public int solve(int n, int A[]) {
            int[] arr = new int[1000 + 1];
            for (int a : A)
                  arr[a]++;

            int[] dp = new int[1000 + 1];
            dp[1] = arr[1];
            dp[2] = 2 * arr[2];

            int max = Math.max(dp[1], dp[2]);
            for (int i = 3; i < 1001; i++) {
                  dp[i] = Math.max(i * arr[i] + dp[i - 2], dp[i - 1]);
                  if (dp[i] > max)
                        max = dp[i];

            }

            return max;
      }
}