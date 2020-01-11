class FloorInSortedArray {
    public int findFloor(int [] arr, int x) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (mid > 0 && arr[mid - 1] <= x && x < arr[mid]) {
                return mid - 1;
            } else if (arr[mid] > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
