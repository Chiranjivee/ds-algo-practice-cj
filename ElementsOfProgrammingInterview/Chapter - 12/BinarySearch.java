class BinarySearch {

    public int binarySearch(int[] input, int k) {
        return binarySearch(input, 0, input.length - 1, k);
    }

    public int binarySearch(int [] input, int start, int end, int k) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (input[mid] == k) {
            return mid;
        }
        return 
            input[mid] < k ? 
                binarySearch(input, mid + 1, end, k) :
                binarySearch(input, start, mid - 1, k);
    }
    public static void main(String[] args) {
        int [] arr = new int [] { 21, 109, 180 };
        BinarySearch searcher = new BinarySearch();
        System.out.println(searcher.binarySearch(arr, 1000));
    }
}