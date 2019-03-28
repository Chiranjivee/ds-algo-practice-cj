import java.util.Arrays;

class JobSchedulingWithMinCost {

    public static int minCost(int [][] jobs, int n, int p, int mask, int [] dp) {
        if (p == n) {
            return 0;
        }

        if (dp[mask] != Integer.MAX_VALUE) {
            return dp[mask];
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if ((mask & (1 << j)) == 0) {
                int ans = minCost(jobs, n, p + 1, mask | (1 << j), dp) + jobs[p][j];
                min = Math.min(min, ans);
            }
        }
        return dp[mask] = min;
    }
    public static void main(String [] args) {
        int [][] jobs = new int[][] {
            {10, 2, 6, 5},
            {1, 15, 12, 8},
            {7, 8, 9, 3},
            {15, 13, 4, 10}
        };

        int [] dp = new int[(int) Math.pow(2, 4) - 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int ans = minCost(jobs, 4, 0, 0, dp);
        System.out.println(ans);
    }
}