class RearrangePositiveAndNegativeAlternatively {
    public int rearrangePositiveAndNegativeAlternatively(int [] arr) {
        pivotAgainstZero(arr);
        int start = 0;
        int end = n - 1;

        while (start < n && start < end && arr[start] < 0) {
            swap(arr, start, end);
            start += 2;
            end--;
        }
    }

    public void pivotAgainstZero(int [] arr) {
        int i = -1;
        int n = arr.length;

        for (int j = 0; j < n; j++) {
            if (arr[j] < 0) {
                swap(arr, i++, j);
            }
        }
    }

    public void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
