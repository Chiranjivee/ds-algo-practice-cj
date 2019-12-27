class MoveZeroesToEnd {
    void pushZeroesToEnd(int [] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i];
            }
        }

        while (count < n) {
            arr[count++] = 0;
        }
    }

    void pushZeroesToEndSet2(int [] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, count++, i);
            }
        }
    }

    void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
