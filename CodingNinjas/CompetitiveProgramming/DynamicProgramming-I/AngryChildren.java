import java.util.Scanner;
import java.util.Arrays;

public class AngryChildren {
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		long cost = 0;
		long sum = arr[0];
		for (int i = 1; i < k; i++) {
			cost += (i * arr[i] - sum);
			sum += arr[i];
		}
		long ans = cost;
		for (int i = k; i < n; i++) {
			sum -= arr[i - k];
			cost -= (sum - (k - 1) * arr[i - k]);
			cost += ((k - 1) * arr[i] - sum);
			ans = Math.min(cost, ans);
			sum += arr[i];
		}
		System.out.println(ans);
	}
}
