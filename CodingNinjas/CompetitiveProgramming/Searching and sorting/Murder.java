import java.util.Scanner;

public class Murder {
	public static void main(String[] args) {
		// Write your code here
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int arrSize = in.nextInt();
			int[] arr = new int[arrSize];
			for (int j = 0; j < arrSize; j++) {
				arr[j] = in.nextInt();
			}

			System.out.println(solve(arr));
		}
	}

	public static long solve(int[] arr) {
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					sum += arr[j];
				}
			}
		}
		return sum;
	}
}
