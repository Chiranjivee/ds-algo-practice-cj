class KthLargestAndSmallest {
    public int kthLargest(int [] arr, int k, int start, int end) {
        int randIdx = random.nextInt(arr.length);
        swap(arr, randIdx, arr.length - 1);
        int partitionIdx = partition(arr, start, end);

        if (partitionIdx == k - 1) {
            return arr[partitionIdx];
        }

        if (partitionIdx < k - 1) {
            return kthLargest(arr, k, partitionIdx + 1, end);
        } else {
            return kthLargest(arr, k, start, partitionIdx - 1);
        }
    }
}
