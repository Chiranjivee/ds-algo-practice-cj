class InsertionSort {
    public void sort(int [] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return;
        }

        for (int i = 2; i < arr.length; i++) {
            int element = arr[i];
            int j = i - 1;
            while (j >= 0 && element <= arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j] = element;
        }
    }
}
