class IsArrayHeap {
    public boolean isHeap(int [] arr) {
        return isHeap(arr, 0);
    }

    public boolean isHeap(int [] arr, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (i > (n - 2) / 2) { 
            return true; 
        }

        if (!(arr[i] >= arr[l] && arr[i] >=  arr[r])) {
            return false;
        }

        boolean isLeftHeap = isHeap(arr, l);
        boolean isRightHeap = isHeap(arr, r);

        return isLeftHeap && isRightHeap;
    }
}
