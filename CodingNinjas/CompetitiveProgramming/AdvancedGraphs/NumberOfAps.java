import java.util.Arrays;

public class NumberOfAps {
    static int MOD = 100001;
	public static int numOfAP(int arr[], int N){
        int max = arr[0];
        for (int i = 0; i < N; i++) {
            max = Math.max(max, arr[i]);
        }

        long ans = N + 1;
        long dp[][][] = new long[2][N][max];

        for (int i = N - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = arr[j] - arr[i];
                if (diff >= 0) dp[0][j][diff] += 1;
                else if (diff < 0) dp[1][j][-diff] += 1;
                ans++;
            }
        }

        ans %= MOD;
        for (int i = N - 3; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                int d = arr[i] - arr[j];
                if (d >= 0) {
                    long sequenceStartingAtJWithDiffPositiveD = dp[0][j][d];
                    if (sequenceStartingAtJWithDiffPositiveD >= 0) {
                        dp[0][i][d] += dp[0][j][d];
                        ans += dp[0][j][d];
                        ans %= MOD;
                    }
                } else {
                    long sequenceStartingAtJWithDiffNegativeD = dp[1][j][-d];
                    if (sequenceStartingAtJWithDiffNegativeD >= 0) {
                        dp[1][i][-d] += dp[1][j][-d];
                        ans += dp[1][j][-d];
                        ans %= MOD;
                    }
                }
            }
        }

        return (int) ans;
    }
}
