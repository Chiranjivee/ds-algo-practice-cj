class CountNumberOfOccurances {
    int countOccurances(int [] arr, int x) {
        int idx = binarySearch(arr, x);
        if (idx == -1) {
            return 0;
        }

        int count = 1;

        int temp = idx - 1;
        while (temp >= 0) {
            if (arr[temp] == x) count++;
        }

        temp = idx + 1;
        while (temp <= arr.length - 1) {
            if (arr[temp] == x) count++;
        }

        return count;
    }
}
