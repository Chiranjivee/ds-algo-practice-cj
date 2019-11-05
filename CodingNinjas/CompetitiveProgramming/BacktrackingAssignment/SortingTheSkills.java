import java.util.*;

public class SortingTheSkills {
	static int count = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		System.out.println("T: " + t);
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextInt();

			}
			System.out.println("soln:" + solveArr(arr));
		}

	}

	public static boolean solveArr(int[] arr) {
		System.out.println(Arrays.toString(arr));
		if (arr.length == 0 || arr.length == 1) {
			return true;
		}

		return divide(arr, 0, arr.length - 1);
	}

	public static boolean divide(int[] arr, int start, int end) {

		if (start == end) {

			return true;
		}

		int mid = start + (end - start) / 2;
		boolean lResult = divide(arr, start, mid);
		boolean rResult = divide(arr, mid + 1, end);

		boolean mergeResult = merge(arr, start, mid, end);
		return lResult && rResult && mergeResult;
		// left half ka last sould be greater than right half ka first.
	}

	public static boolean merge(int[] arr, int start, int mid, int end) {
		int[] left = Arrays.copyOfRange(arr, start, mid + 1);
		int[] right = Arrays.copyOfRange(arr, mid + 1, end + 1);
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));
		if (Math.abs(left[left.length - 1] - right[0]) > 1) {
			System.out.println("Left: " + left[left.length - 1] + ", right: " + right[0]);
			return false;
		}

		int l = 0;
		int r = 0;
		int m = start;

		while (l < left.length || r < right.length) {
			int lValue = l >= left.length ? Integer.MAX_VALUE : left[l];
			int rValue = r >= right.length ? Integer.MAX_VALUE : right[r];

			if (lValue < rValue) {
				arr[m++] = lValue;
				l++;
			} else {
				arr[m++] = rValue;
				r++;
			}
		}

		return true;
	}
}
