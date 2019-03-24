import java.util.Scanner;
import java.util.Arrays;

class MarbelGame {
	public static void main(String[] args) {
		// Write your code here
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int target = in.nextInt();
		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(Arrays.toString(arr));
		StringBuilder result;
		for (int i = 0; i < num; i++) {
			// start from i and add marbles until you reach target
			int temp = 0;
			result = new StringBuilder();
			if (arr[i] == 0) {
				System.out.println("Current: " + arr[i]);
				continue;
			}

			for (int j = i; j < num || temp <= target; j++) {
				if (temp == target) {
					result.setLength(result.length() - 1);
					System.out.println("true");
					System.out.println(result);
					return;
				}
				temp += arr[j];
				System.out.println("Temp is: " + temp);
				result.append(arr[j] + " ");
			}
		}

		System.out.println("false");
	}
}