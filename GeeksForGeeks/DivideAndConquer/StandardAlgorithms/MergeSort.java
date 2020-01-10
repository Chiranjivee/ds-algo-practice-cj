class MergeSort {
    public void sort(int [] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        sort(arr, start, mid);
        sort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    public void merge(int [] arr, int start, int mid, int end) {
        // 

        int [] l = new int [mid - start + 1];
        int [] r = new int [end - mid];

        for (int i = 0; i < l.length; i++) {
            l[i] = arr[start + i];
        }

        for (int i = 0; i < r.length; i++) {
            r[i] = arr[mid + 1 + i];
        }

        int n = l.length;
        int m = r.length;

        int i = 0; 
        int j = 0;
        int k = start;

        while (i < n && j < m) {
            if (l[i] < r[i]) {
                arr[k] = l[i];
                i++; k++;
            } else if (r[i] <= l[i]) {
                arr[k] = r[i];
                j++; k++;
            }
        }

        while (i < n) {
            arr[k++] = l[i++];
        }

        while (j < m) {
            arr[k++] = r[j++];
        }
    }

    public void run() {
        int [] arr = new int [] {1, 2, 3, 4, 5};
        MergeSort sorter = new MergeSort();
        sorter.sort(arr, 0, arr.length - 1);

    }
}