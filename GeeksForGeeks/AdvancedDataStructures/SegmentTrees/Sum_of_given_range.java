class SegmentTree {
    int segmentTree[];

    SegmentTree(int arr, int n) {
        this.segmentTree = new int [n * 2];
        constructSegmentTree(arr, 0, n - 1, 0);
    }

    public int constructSegmentTree(int arr[], int ss, int se, int n) {
        if (ss == se) {
            tree[n] = arr[ss];
            return arr[ss];
        }
        int mid = (ss + se) / 2;
        int leftMin = constructSegmentTree(arr, ss, mid, n * 2 + 1);
        int rightMin = constructSegmentTree(arr, mid + 1, se, n * 2 + 2);

        tree[n] = leftMin + rightMin;
        return tree[n];
    }
    
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6};
        int n = arr.length;
        SegmentTree segmentTree = new SegmentTree(arr, n);
    }
}