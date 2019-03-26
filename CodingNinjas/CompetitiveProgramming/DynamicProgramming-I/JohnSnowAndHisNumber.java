import java.util.Scanner;

public class JohnSnowAndHisNumber {
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int x = sc.nextInt();

		int[] arr = new int[1024];
		for (int i = 0; i < n; i++) {
			arr[sc.nextInt()]++;
		}
		sc.close();
		solve(arr, k, x);
	}

	public static void solve(int[] arr, int k, int x) {
		for (int i = 0; i < k; i++) {
			int takenSoFar = 0;
			int[] temp = new int[1024];
			for (int j = 0; j < 1024; j++) {
				if (arr[j] % 2 == 0) {
					temp[j] += arr[j] / 2;
					temp[j ^ x] += arr[j] / 2;
				} else if (takenSoFar % 2 == 0) {
					temp[x ^ j] += ((arr[j] / 2) + 1);
					temp[j] += arr[j] / 2;
				} else {
					temp[j] += ((arr[j] / 2) + 1);
					temp[x ^ j] += arr[j] / 2;
				}
				takenSoFar += arr[j];
			}
			arr = temp;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= 1023; i++) {
			if (arr[i] != 0) {
				min = i;
				break;
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1023; i >= 1; i--) {
			if (arr[i] != 0) {
				max = i;
				break;
			}
		}

		System.out.println(max + " " + min);
	}
}
