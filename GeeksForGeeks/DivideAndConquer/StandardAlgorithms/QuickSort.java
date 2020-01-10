class QuickSort {
    public void sort(int [] arr, int start, int end) {
        int pivot = partitionArrayAndGetPivotIndex(arr);
        sort(arr, start, pivot - 1);
        sort(arr, pivot + 1, end);
    }

    public int partitionArrayAndGetPivotIndex(int [] arr, int start, int end) {
        int pivotElement = arr[end];
        int i = -1;

        for (int j = start; j <= end - 1; j++) {
            if (arr[j] < pivotElement) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
}
