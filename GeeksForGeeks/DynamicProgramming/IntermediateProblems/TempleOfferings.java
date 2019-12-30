import java.util.Arrays;

class TempleOfferings {
    public int getMinOfferings(int [] arr) {

        int [] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1] && dp[i] < dp[i + 1]) {
                dp[i] = 1 + arr[i + 1];
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res += dp[i];
        }

        return res;
    }
}
