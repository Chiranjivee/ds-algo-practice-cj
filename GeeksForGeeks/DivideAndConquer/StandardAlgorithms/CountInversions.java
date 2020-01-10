class CountInversions {
    public void solve(int [] arr) {

    }

    public int sort(int [] arr, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = (start + end) / 2;

        int l = sort(arr, start, mid);
        int r = sort(arr, mid + 1, end);

        int m = merge(arr, start, mid, end);

        return l + r + m;
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

        int swaps = 0;

        while (i < n && j < m) {
            if (l[i] < r[j]) {
                arr[k] = l[i];
                i++; k++;
            } else if (r[j] <= l[i]) {
                arr[k++] = r[j++];
                swaps += (mid + 1) - (l + i);
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
