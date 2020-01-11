class MajorityElementInSortedArray {
    static int binarySearch(int arr[], int low, int high, int x) {
        if (high >= low) {
            int mid = (low + high) / 2;
            if ((mid == 0 || x > arr[mid - 1]) && (arr[mid] == x))
                return mid;
            else if (x > arr[mid])
                return binarySearch(arr, (mid + 1), high, x);
            else
                return binarySearch(arr, low, (mid - 1), x);
        }
    
        return -1;
    }

    static boolean isMajority(int arr[], int n, int x) {
        /* Find the index of first occurrence of x in arr[] */
        int i = binarySearch(arr, 0, n - 1, x);

        if (i == -1)
            return false;

        if (((i + n / 2)<= (n - 1)) && arr[i + n / 2] == x) return true;
        else return false;
    }
}
