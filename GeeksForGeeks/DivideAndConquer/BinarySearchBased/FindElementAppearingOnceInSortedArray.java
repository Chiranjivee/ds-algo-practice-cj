class FindElementAppearingOnceInSortedArray {
    public int search(int [] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;

            if (mid % 2 == 0) {
                if (arr[mid] == arr[mid] + 1) {
                    start = mid + 2;
                } else {
                    end = mid;
                }
            } else {
                if (arr[mid] == arr[mid] - 1) {
                    start = mid + 1;
                } else {
                    end = mid - 2;
                }
            }
        }

        return mid;
    }
}
