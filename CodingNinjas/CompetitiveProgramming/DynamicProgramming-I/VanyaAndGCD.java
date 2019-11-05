import java.util.Scanner;

public class VanyaAndGCD {
	static int MOD = 1_000_000_000 + 7;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(solve(arr));
	}

	public static long solve(int[] arr) {
		long[][] dp = new long[arr.length][101];
		for (int i = 0; i < arr.length; i++) {
			dp[i][arr[i]] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i]) {
					for (int g = 1; g <= 100; g++) {
						if (dp[j][g] > 0) {
							int GCD = gcd(g, arr[i]);
							dp[i][GCD] += dp[j][g];
						}
					}
				}
			}
		}

		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += dp[i][1];
			sum %= MOD;
		}
		return sum;
	}

	public static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}
}
