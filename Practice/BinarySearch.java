class BinarySearch {
    public static int searchUtil(int[] arr, int start, int end, int key) {
        
    }

    public static int search(int[] arr, int key) {
        return searchUtil(arr, 0, arr.length - 1, key);
    }

    public static void main(String[] args) {
        int[] input = { 10, 20, 30, 40, 50 };
        System.out.println(search(input, 50));
    }
}
