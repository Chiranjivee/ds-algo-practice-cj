class RotationCount {
    public int rotationCount(int [] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return mid;
            } else if (mid < end && arr[mid + 1] < arr[mid]) {
                return mid + 1;
            }

            if (arr[mid] < arr[end]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }
}
