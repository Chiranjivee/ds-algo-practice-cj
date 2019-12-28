class Rearrange {
    // sinuoidal sort
    public void solve(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0 && arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            } else if (i % 2 != 0 && arr[i] < arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
    }
}
