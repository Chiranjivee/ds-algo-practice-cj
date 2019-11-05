import java.util.Scanner;

public class Main {

    public static long func(int n, int[] visited, int i, long[] dp) {

        if (i == n) {
            return 1;
        }

        int mask = 0;
        for (int p = 0; p <= n; p++) {
            if (visited[p] != 0) {
                mask += (int) Math.pow(2, p);
            }
        }

        if (dp[mask] != -1) {
            return dp[mask];
        }

        long ans = 0;

        for (int k = 1; k <= n; k++) {

            int flag = 0;

            for (int j = 1; j <= n; j++) {

                if (visited[j] != 0) {

                    int and = k & j;

                    if (and == k) {
                        flag = 1;
                        break;
                    }

                    else {

                    }

                }
            }

            if (flag == 0) {
                visited[k]++;
                ans += func(n, visited, i + 1, dp);
                visited[k]--;
            }

        }

        return dp[mask] = ans;

    }

    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int visited[] = new int[n + 1];

        long dp[] = new long[(int) Math.pow(2, n + 1)];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }

        long ans = 0;

        for (int i = 1; i <= n; i++) {
            visited[i] = 1;
            ans += func(n, visited, 1, dp);
            visited[i] = 0;
        }

        System.out.println(ans);
    }
}