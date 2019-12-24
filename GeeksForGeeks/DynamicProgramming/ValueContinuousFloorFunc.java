class Solution {
    static int [] dp = new int[1000];
    public int computeContinuousFloor(int x) {
        if (x == 0) {
            return 0;
        }

        if (dp[x] != -1) {
            return dp[x];
        }

        return dp[x] = x + computeContinuousFloor(x / 2);
    }

    public int getSol(int [] arr) {
        for (int x : arr) {
            System.out.println(computeContinuousFloor(x));
        }
    }
}
