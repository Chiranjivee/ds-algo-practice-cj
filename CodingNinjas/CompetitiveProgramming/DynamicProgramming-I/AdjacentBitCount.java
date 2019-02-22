import java.util.Scanner;

public class AdjacentBitCount {

    static int MOD = 1_000_000_000 + 7;

    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int dataSet = sc.nextInt();
            int nB = sc.nextInt();
            int adjBitCount = sc.nextInt();
            int[][][] dp = new int[nB + 1][adjBitCount + 1][2];
            for (int a = 0; a <= nB; a++) {
                for (int b = 0; b <= adjBitCount; b++) {
                    for (int c = 0; c < 2; c++) {
                        dp[a][b][c] = -1;
                    }
                }
            }

            int optionOne = solve(nB, adjBitCount, 1, dp);
            int optionTwo = solve(nB, adjBitCount, 0, dp);
            int ans = ((optionOne % MOD) + (optionTwo % MOD)) % MOD;
            System.out.println(dataSet + " " + ans);
        }
    }

    public static int solve(int n, int k, int f, int[][][] dp) {
        if (n == 1) {
            if (k == 0) {
                return 1;
            }
            return 0;
        }

        if (k < 0)
            return 0;
        if (dp[n][k][f] != -1) {
            return dp[n][k][f];
        }

        if (f == 1) {
            int optionOne = solve(n - 1, k - 1, 1, dp);
            int optionTwo = solve(n - 1, k, 0, dp);
            int temp = ((optionOne % MOD) + (optionTwo % MOD)) % MOD;
            dp[n][k][f] = temp;
        } else {
            int optionOne = solve(n - 1, k, 1, dp);
            int optionTwo = solve(n - 1, k, 0, dp);
            int temp = ((optionOne % MOD) + (optionTwo % MOD)) % MOD;
            dp[n][k][f] = temp;
        }

        return dp[n][k][f];
    }
}
