public class BinarySearch {

	public static int binarySearch(int[] array, int start, int end, int key) {
		if (start > end) {
			return -(start + 1);
		}

		int mid = start + (end - start) / 2;

		if (array[mid] == key) {
			return mid;
		}

		return array[mid] > key ? binarySearch(array, start, mid - 1, key) : binarySearch(array, mid + 1, end, key);
	}

	public static int binarySearchIterative(int[] array, int key) {
		int start = 0;
		int end = array.length;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == key) {
				return mid;
			} else if (array[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return -(start + 1);
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };
		int idx = binarySearch(arr, 0, arr.length - 1, 23);
		System.out.println(idx);
		idx = binarySearchIterative(arr, 23);
		System.out.println(idx);
	}
}
