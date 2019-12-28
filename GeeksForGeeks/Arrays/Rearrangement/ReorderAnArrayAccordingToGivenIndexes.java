class ReorderAnArrayAccordingToGivenIndex {
    public void reorder(int [] arr, int [] indx) {
        
        for (int i = 0; i < arr.length; i++) {
            int correctIndex = indx[i];
            while (indx[i] != i) {
                swap(indx, i, correctIndex);
                swap(arr, i, correctIndex);
            }
        }
    }

    public void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
