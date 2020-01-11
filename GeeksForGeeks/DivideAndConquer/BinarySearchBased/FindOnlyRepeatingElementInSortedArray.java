class FindOnlyRepeatingElementInSortedArray {
    public int findRepeating(int [] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] != mid + 1) {
                if (mid > 0 && arr[mid] == arr[mid = 1]) {
                    return mid;
                }

                start = mid - 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}