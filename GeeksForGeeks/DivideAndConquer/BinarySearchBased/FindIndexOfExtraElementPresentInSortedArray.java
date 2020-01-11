class FindIndexOfExtraElementPresentInSortedArray {
    public int findIdx(int [] arr1, int [] arr2) {
        int start = 0;
        int end = arr1.length - 1;
        
        int index = arr1.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr1[mid] == arr2[mid]) {
                start = mid + 1;
            } else {
                index = mid;
                end = mid - 1;
            }
        }

        return index;
    }
}
