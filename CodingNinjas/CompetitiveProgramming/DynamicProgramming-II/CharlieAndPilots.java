import java.util.*;

public class CharlieAndPilots {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] assistant = new int[n];
		int[] captain = new int[n];

		for (int i = 0; i < n; i++) {
			captain[i] = sc.nextInt();
			assistant[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(solveIterativeOptimized(assistant, captain));
	}

	public static int solveIterative(int[] assistant, int[] captain) {
		int n = captain.length;
		int[][] dp = new int[n + 1][n + 1];
		Arrays.fill(dp[0], -1);
		Arrays.fill(dp[1], -1);
		dp[1][1] = captain[n - 1];

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (j == 0) {
					dp[i][j] = assistant[n - i] + dp[i - 1][j + 1];
				} else if (j == i) {
					dp[i][j] = captain[n - i] + dp[i - 1][j - 1];
				} else {
					int optionOne = j + 1 > n ? Integer.MAX_VALUE : assistant[n - i] + dp[i - 1][j + 1];
					int optionTwo = captain[n - i] + dp[i - 1][j - 1];
					dp[i][j] = Math.min(optionOne, optionTwo);
				}
			}
		}

		return dp[n][0];
	}

	public static int solveIterativeOptimized(int[] assistant, int[] captain) {
		int n = captain.length;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		dp[1] = captain[n - 1];

		for (int i = 2; i <= n; i++) {
			int[] temp = new int[n + 1];
			for (int j = 0; j <= n; j++) {
				if (j == 0) {
					temp[j] = assistant[n - i] + dp[j + 1];
				} else if (j == i) {
					temp[j] = captain[n - i] + dp[j - 1];
				} else {
					int optionOne = j + 1 > n ? Integer.MAX_VALUE : assistant[n - i] + dp[j + 1];
					int optionTwo = captain[n - i] + dp[j - 1];
					temp[j] = Math.min(optionOne, optionTwo);
				}
			}
			dp = temp;
		}

		return dp[0];
	}

	public static int solveTopDown(int[] assistant, int[] captain, int idx, int rem, int x, int[][] dp) {
		if (rem <= 0 || x < 0 || x >= dp[0].length) {
			return Integer.MAX_VALUE;
		}

		if (idx == captain.length - 1) {
			if (x == 1)
				return dp[rem][x] = captain[captain.length - 1];
			else
				return Integer.MAX_VALUE;
		}

		if (dp[rem][x] != -1) {
			return dp[rem][x];
		}

		if (x == 0) {
			return dp[rem][x] = assistant[idx] + solveTopDown(assistant, captain, idx + 1, rem - 1, x + 1, dp);
		} else if (x == rem) {
			return dp[rem][x] = captain[idx] + solveTopDown(assistant, captain, idx + 1, rem - 1, x - 1, dp);
		} else {
			int optionOne = assistant[idx] + solveTopDown(assistant, captain, idx + 1, rem - 1, x + 1, dp);
			int optionTwo = captain[idx] + solveTopDown(assistant, captain, idx + 1, rem - 1, x - 1, dp);
			return dp[rem][x] = Math.min(optionOne, optionTwo);
		}
	}
}
