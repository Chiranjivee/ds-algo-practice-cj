class FindPairSumToXInRotatedSortedArray {
    public boolean findPair(int [] arr, int x) {
        int n = arr.length;
        int r = findLargestElementIdx(arr);
        int l = (r + 1) % n;


        while (l != r) {
            int sum = arr[l] + arr[r];
            if (sum == x) {
                return true;
            } else if (sum < x) {
                l = (l + 1) % n;
            } else {
                r = (n + r - 1) % n;
            }
        }

        return false;
    }
}
