class SortArrayWith012 {
    public void sort(int [] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int mid = 0;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0: 
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }
}
