import java.util.Arrays;

public class SubsetSumK {

	static int current = 0;

	// Return a 2D array that contains all the subsets
	public static int[][] subsetsSumK(int input[], int k) {
		// Write your code here
		int resultSize = (int) Math.pow(2, input.length);
		int[][] result = new int[resultSize][];
		int[] temp = new int[input.length];
		subsetsUtil(input, result, temp, 0, 0, k);
		return result;
	}

	public static void main(String[] args) {
		int[][] res = subsetsSumK(new int[] { 1, 2 }, 1);
		System.out.println("res " + Arrays.toString(res));
	}

	public static void subsetsUtil(int input[], int[][] result, int[] temp, int resIdx, int i, int k) {
		if (i == input.length) {
			int[] arr = Arrays.copyOf(temp, input.length);
			if (isArraySumK(arr, k)) {
				result[current++] = arr;
			}

			return;
		}

		subsetsUtil(input, result, temp, resIdx, i + 1, k);
		temp[resIdx] = input[i];
		subsetsUtil(input, result, temp, resIdx + 1, i + 1, k);
	}

	public static boolean isArraySumK(int[] arr, int k) {
		System.out.println("K: " + k);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("sum: " + sum);
		return true;
	}
}
