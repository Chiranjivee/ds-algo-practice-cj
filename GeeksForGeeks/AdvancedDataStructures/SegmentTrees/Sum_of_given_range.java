class SegmentTree {
    int segmentTree[];

    public SegmentTree(int [] arr, int n) {
        this.segmentTree = new int [n * 2 + 1];
        constructSegmentTree(arr, 0, n - 1, 0);
    }

    public void printSegmentTree() {
        System.out.println("\nPrinting segment Tree:");
        for (int i = 0; i < this.segmentTree.length; i++) {
            System.out.print(this.segmentTree[i] + ", ");
        }
    }

    public int constructSegmentTree(
        int arr[], 
        int segmentStart, 
        int segmentEnd, 
        int nodeIndex) 
    {
        if (segmentStart == segmentEnd) {
            segmentTree[nodeIndex] = arr[segmentStart];
            return arr[segmentStart];
        }
        int mid = (segmentStart + segmentEnd) / 2;
        int leftMin = constructSegmentTree(arr, segmentStart, mid, nodeIndex * 2 + 1);
        int rightMin = constructSegmentTree(arr, mid + 1, segmentEnd, nodeIndex * 2 + 2);

        segmentTree[nodeIndex] = leftMin + rightMin;
        return segmentTree[nodeIndex];
    }

    public int getSumInRange(int rangeStart, int rangeEnd, int n) {
        if (rangeStart < 0 || rangeEnd > n || rangeStart > rangeEnd) {
            System.out.println("Invalid input");
            return -1;
        }

        return getSumInRangeUtil(this.segmentTree, 0, n - 1, rangeStart, rangeEnd, 0);
    }

    public int getSumInRangeUtil(int [] segmentTree, int segmentStart, int segmentEnd, int rs, int re, int node) {
        if (rs == segmentStart && re == segmentEnd) {
            return segmentTree[node];
        }

        if (segmentEnd < rs || re < segmentStart) {
            return 0;
        }

        if (segmentStart == segmentEnd) {
            return segmentTree[node];
        }

        int mid = segmentStart + (segmentEnd - segmentStart) / 2;
        return 
            getSumInRangeUtil(segmentTree, segmentStart, mid, rs, re, node * 2 + 1) + 
            getSumInRangeUtil(segmentTree, mid + 1, segmentEnd, rs, re, node * 2 + 2);
    }

    public void updateArray(int [] arr, int index, int value) {
        if (index < 0 || index >= arr.length) {
            System.out.println("Invalid input");
        }

        int sumDiff = value - arr[index];
        arr[index] = value;
        updateSegmentTreeUtil(index, sumDiff, 0, arr.length - 1, 0);
    }

    public void updateSegmentTreeUtil(int index, int sumDiff, int segmentStart, int segmentEnd, int node) {
        if (index < segmentStart || index > segmentEnd) {
            return;
        }

        segmentTree[node] += sumDiff;
        if (segmentStart != segmentEnd) {
            int mid = segmentStart + (segmentEnd - segmentStart) / 2;
            updateSegmentTreeUtil(index, sumDiff, segmentStart, mid, node * 2 + 1);
            updateSegmentTreeUtil(index, sumDiff, mid + 1, segmentEnd, node * 2 + 2);
        }
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6};
        int n = arr.length;
        SegmentTree segTree = new SegmentTree(arr, n);
        printArray(arr);
        
        segTree.printSegmentTree();
        System.out.println();
        System.out.println(segTree.getSumInRange(0, 5, 6));

        segTree.updateArray(arr, 4, 90);
        printArray(arr);
        segTree.printSegmentTree();
    }

    public static void printArray(int [] arr) {
        System.out.println("Printin array");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
