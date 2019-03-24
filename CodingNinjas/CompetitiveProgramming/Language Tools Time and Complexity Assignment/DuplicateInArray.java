public class DuplicateInArray {

	public static int duplicate(int[] arr) {
		/*
		 * Your class should be named DuplicateInArray Don't write main(). Don't read
		 * input, it is passed as function argument. Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
		int n = arr.length - 1;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += i;
		}

		int arrSum = 0;
		for (int i = 0; i < arr.length; i++) {
			arrSum += arr[i];
		}
		return arrSum - sum;
	}
}
