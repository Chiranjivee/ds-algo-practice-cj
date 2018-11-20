class SearchSortedForIndex {

    public static int binarySearch(int [] input) {
        int start = 0;
        int end = input.length - 1;
        int mid = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            System.out.println("Mid is: " + mid);
            if (input[mid] == mid) {
                return mid;
            } else if (input[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }
    public static void main(String[] args) {
        int [] input = {-1, 1, 3, 4, 5, 6};
        System.out.println(binarySearch(input));
    }
}