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

    public int rearrangePositiveAndNegativeAlternativelyWithOrderMaintain(int [] arr) {
        // -ve at odd
        // +ve at even
        int outOfPlace = -1;
        for (int i = 0; i < arr.length; i++) {
            if (outOfPlace > -1) {
                if (arr[i] >= 0 && arr[outOfPlace] < 0
                    || arr[i] < 0 && arr[outOfPlace] >= 0) {

                    rightRotate(arr, outOfPlace, i);
                    if (index - outOfPlace > 2) {
                        outOfPlace += 2;
                    } else {
                        outOfPlace = -1;
                    }
                }
            }

            else if (outOfPlace == -1 && arr[i] < 0 && (i % 2 == 1) || arr[i] > 0 && i % 2 == 0) {
                outOfPlace = i;
            }
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
