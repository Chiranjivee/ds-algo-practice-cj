class SearchInAlmostSortedArray {
    public int search(int [] arr, int x) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == x) {
                return mid;
            } if (mid > 0 && arr[mid - 1] == x) {
                return mid - 1;
            } if (mid < arr.length - 1 && arr[mid + 1] == x) {
                return mid + 1;
            }

            if (mid > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
