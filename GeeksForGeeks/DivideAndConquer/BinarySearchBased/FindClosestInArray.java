class FindClosestInArray {
    public int findClosestInArray(int [] arr, int x) {
        int n = arr.length;
        if (x <= arr[0]) {
            return arr[0];
        } else if (x >= arr[n - 1]) {
            return arr[n - 1];
        }

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == x) {
                return x;
            } else if (arr[mid] > x) {
                if (mid > 0 && x > arr[mid] - 1) {
                    return getClosest(arr[mid], arr[mid - 1], x);
                }
                end = mid - 1;
            } else {
                if (mid < n - 1 && x < arr[mid + 1]) {
                    return getClosest(arr[mid], arr[mid + 1], x);
                }
                start = mid + 1;
            }
        }

        return arr[mid];
    }

    public int getClosest(int x, int y, int z) {
        if (Math.abs(z - x)  > Math.abs(y - z)) {
            return y;
        } else {
            return x;
        }
    }
}
