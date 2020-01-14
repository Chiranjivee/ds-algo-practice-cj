class PartitionSubsetIntoKSubset {
    public boolean partitionIntoK(int [] arr, int indx, int sum, int k) {
        if (indx == arr.length && k == 0 && sum == 0) {
            return true;
        }

        int sum = 0;
        for (int i = indx; i < arr.length; i++) {
            sum += arr[i];
            if (partitionIntoK(arr, indx + 1, sum, k - 1)) {
                return true;
            }
        }

        return false;
    }
}
