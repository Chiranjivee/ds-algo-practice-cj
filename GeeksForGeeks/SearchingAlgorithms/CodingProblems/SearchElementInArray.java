class SearchElementInArrayWithAdjacentDiffOne {
    public int search(int [] arr, int k) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] ==  k) {
                return i;
            }

            i += Math.abs(k - arr[i]);
        }

        return -1;
    }
}
