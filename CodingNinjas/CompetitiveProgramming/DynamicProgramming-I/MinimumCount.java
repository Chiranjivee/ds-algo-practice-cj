import java.util.Arrays;

public class MinimumCount {
    public static int minCount(int n) {
      if (n == 1 || n == 2 || n == 3) {
        return n;
      }

      int [] dp = new int [n + 1];
      dp[1] = 1;
      dp[2] = 2;
      dp[3] = 3;

      int sqrt = (int) Math.floor(Math.sqrt(n));
      if (sqrt * sqrt == n) {
        return 1;
      }

      for (int i = 4; i <= n; i++) {
        int sqr = (int) Math.floor(Math.sqrt(i));
        if (sqr * sqr == i) {
          dp[i] = 1;
        } else {
          dp[i] = Integer.MAX_VALUE;
          for (int j = 1; j <= sqr; j++) 
            dp[i] = Math.min(dp[i], dp[j * j] + dp[i - (j * j)]);
        }
      }
	  return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(minCount(12));
    }
}
