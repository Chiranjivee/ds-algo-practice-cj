public class BinarySearch {

	// element - number to be searched
	public static int binarySearch(int input[], int element) {
		// Write your code here
		return binarySearch(input, 0, input.length - 1, element);
	}

	public static int binarySearch(int input[], int start, int end, int element) {
		if (start > end) {
			return -1;
		}

		int mid = start + (end - start) / 2;
		if (input[mid] == element) {
			return mid;
		}

		return 
			input[mid] > element ?
				binarySearch(input, start, mid - 1, element):
				binarySearch(input, mid + 1, end, element);
	}
}
