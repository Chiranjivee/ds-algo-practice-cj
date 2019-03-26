import java.util.Scanner;

public class SquareBrackets {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            boolean[] s = new boolean[2 * n];
            for (int i = 0; i < k; i++) {
                s[sc.nextInt() - 1] = true;
            }

            int[][] dp = new int[n + 1][n + 1];
            System.out.println(solveUtil(0, 0, n, s, 0, dp));
        }
    }

    public static int solveUtil(int open, int close, int n, boolean[] s, int curr, int[][] dp) {
        if (open == n && close == n) {
            return 1;
        }

        if (dp[open][close] != 0) {
            return dp[open][close];
        }

        if (open == n) {
            if (s[curr])
                return 0;
            return dp[open][close] = solveUtil(open, close + 1, n, s, curr + 1, dp);
        }

        if (open == close || s[curr]) {
            return dp[open][close] = solveUtil(open + 1, close, n, s, curr + 1, dp);
        } else {
            int optionOne = solveUtil(open + 1, close, n, s, curr + 1, dp);
            int optionTwo = solveUtil(open, close + 1, n, s, curr + 1, dp);
            return dp[open][close] = optionOne + optionTwo;
        }
    }
}
