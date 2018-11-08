class BinarySearch {

    public int search(int [] arr, int start, int end, int key) {
        if (arr == null || arr.length == 0) return -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < key) {
                start = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else if (arr[mid] == key) {
                return mid;
            }
        }

        return -1;
    }

    public int searchRecursive(int [] arr, int start, int end, int key) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (arr[mid] == key) return mid;

        return arr[mid] < key ? 
            searchRecursive(arr, mid + 1, end, key):
            searchRecursive(arr, start, mid - 1, key);
    }
    public static void main(String[] args) {
        int [] input = { 11, 22, 33, 44, 55 };
        BinarySearch binarySearch = new BinarySearch();
        System.out.println("Index of 11: " + binarySearch.search(input, 0, input.length - 1, 11));
        System.out.println("Index of 22: " + binarySearch.search(input, 0, input.length - 1, 22));
        System.out.println("Index of 33: " + binarySearch.search(input, 0, input.length - 1, 33));
        System.out.println("Index of 44: " + binarySearch.search(input, 0, input.length - 1, 44));
        System.out.println("Index of 45: " + binarySearch.search(input, 0, input.length - 1, 45));

        System.out.println("Index of -12: " + binarySearch.search(input, 0, input.length - 1, -12));
        System.out.println("Index of 100: " + binarySearch.search(input, 0, input.length - 1, 100));
        System.out.println("Index of 1: " + binarySearch.search(input, 0, input.length - 1, 1));
        System.out.println("Index of 1: " + binarySearch.search(input, 0, input.length - 1, 1));

        System.out.println("Index of 11: " + binarySearch.searchRecursive(input, 0, input.length - 1, 11));
        System.out.println("Index of 22: " + binarySearch.searchRecursive(input, 0, input.length - 1, 22));
        System.out.println("Index of 33: " + binarySearch.searchRecursive(input, 0, input.length - 1, 33));
        System.out.println("Index of 44: " + binarySearch.searchRecursive(input, 0, input.length - 1, 44));
        System.out.println("Index of 45: " + binarySearch.searchRecursive(input, 0, input.length - 1, 45));

        System.out.println("Index of -12: " + binarySearch.searchRecursive(input, 0, input.length - 1, -12));
        System.out.println("Index of 100: " + binarySearch.searchRecursive(input, 0, input.length - 1, 100));
        System.out.println("Index of 1: " + binarySearch.searchRecursive(input, 0, input.length - 1, 1));
        System.out.println("Index of 1: " + binarySearch.searchRecursive(input, 0, input.length - 1, 1));

    }
}