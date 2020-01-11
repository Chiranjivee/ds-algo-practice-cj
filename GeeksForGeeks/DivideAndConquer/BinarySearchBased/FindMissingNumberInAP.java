class FindMissingNumberInAP {
    public int findMissingNumberInAP(int [] arr) {
        int d = arr[n - 1] - arr[0] / arr.length;
        return findMissing(arr, d);
    }

    public int findMissing(int [] arr, int d) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int  mid = (start + end) / 2;

            if (arr[mid - 1] + d != arr[mid]) {
                return arr[mid] - d;
            }

            if (arr[mid + 1] - d != arr[mid]) {
                return arr[mid] +d;
            }

            if (arr[mid] == arr[0] + mid * d) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
