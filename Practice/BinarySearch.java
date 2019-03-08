class BinarySearch {
    public static int searchUtil(int [] arr, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        return arr[mid] > key ? 
            searchUtil(arr, start, mid - 1, key) : 
            searchUtil(arr, mid + 1, end, key);
    }

    public static int search(int[] arr, int key) {
        return searchUtil(arr, 0, arr.length - 1, key);
    }

    public static void main(String[] args) {
        int [] input = { 10, 20, 30, 40, 50 };
        System.out.println(search(input, 50));
    }
}

