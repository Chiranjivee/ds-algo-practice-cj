class BinaryIndexTree {
    int [] tree;
    int treeSize;

    public BinaryIndexTree(int [] arr) {
        treeSize = arr.length;
        tree = new int[treeSize];
    }

    public void constructBIT(int [] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            updateBIT(i, length, arr[i]);
        }
    }

    public void updateBIT(int index, int arrLength, int element) {
        
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -1, 9, -8, 17};

        BinaryIndexTree fenwick = new BinaryIndexTree(arr);

    }
}