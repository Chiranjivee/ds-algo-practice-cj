class ReverseArray {
    public void reverse(int [] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, n - i - 1);
        }
    }

    public void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
