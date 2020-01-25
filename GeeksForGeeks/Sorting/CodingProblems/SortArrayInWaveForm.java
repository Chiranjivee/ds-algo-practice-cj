class SortArrayInWaveForm {
    void sortInWave(int arr[], int n) {
        // Sort the input array 
        Arrays.sort(arr);
        for (int i = 0; i<n - 1; i += 2) swap(arr, i, i + 1);
    }
}
