class FindPeak {
    public int findPeak(int [] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid == 0 || arr[mid - 1] <= arr[mid] && mid == n - 1 || arr[mid + 1] <= arr[mid]) {
                return mid;
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }
}