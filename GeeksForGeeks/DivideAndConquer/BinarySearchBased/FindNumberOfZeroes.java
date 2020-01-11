class FindNumberOfZeroes {
    public int findZeroes(int [] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid == 0 || arr[mid - 1] == 1 && arr[mid] == 0) {
                return mid;
            }

            if (arr[mid] == 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}