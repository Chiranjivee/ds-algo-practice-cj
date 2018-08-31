class Practice {
	public int doBinarySearchRecursive(int [] arr, int key, int start, int end) {
		if (start > end) {
			return -1;
		}
	
		int mid = start + (end - start) / 2;
	
	 	if (arr[mid] == key) {
	 		return mid;
	        }
	
		return arr[mid] > key ? 
			doBinarySearchRecursive(arr, key, start, mid - 1) : 
			doBinarySearchRecursive(arr, key, mid + 1, end); 
	
	}

	public int doBinarySearchIterative(int [] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
	
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] > key) {
				end = mid - 1;	
			} else {
				start = mid + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int [] arr = {-100000000,-100000000,-100000000,-100000000,-100000000,-100000000,-100000000,-100000000};
		int [] input = {-10000000};
		int [] expected = {0};

		BinarySearcher binarySearcher = new BinarySearcher();

		System.out.println("Printing input array:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();

		System.out.println("Doing recursive binary search:");
		for (int i = 0 ; i < input.length; i++) {
			System.out.println("Search: " + input[i] + ", expected: " + expected[i] + ", actual: " + 
				binarySearcher.doBinarySearchRecursive(arr, input[i], 0, arr.length - 1));
		}

		System.out.println("Doing iterative binary search:");
		for (int i = 0 ; i < input.length; i++) {
			System.out.println("Search: " + input[i] + ", expected: " + expected[i] + ", actual: " + 
				binarySearcher.doBinarySearchIterative(arr, input[i]));
		}
		
	}
}
