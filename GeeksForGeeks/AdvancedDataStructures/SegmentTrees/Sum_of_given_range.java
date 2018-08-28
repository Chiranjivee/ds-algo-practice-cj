class SegmentTree {
    int segmentTree[];

    SegmentTree(int [] arr, int n) {
        this.segmentTree = new int [n * 2 + 1];
        constructSegmentTree(arr, 0, n - 1, 0);
    }

    public void printSegmentTree() {
        for (int i = 0; i < this.segmentTree.length; i++) {
            System.out.print(this.segmentTree[i] + ", ");
        }
    }

    public int constructSegmentTree(int arr[], int ss, int se, int n) {
        if (ss == se) {
            segmentTree[n] = arr[ss];
            return arr[ss];
        }
        int mid = (ss + se) / 2;
        int leftMin = constructSegmentTree(arr, ss, mid, n * 2 + 1);
        int rightMin = constructSegmentTree(arr, mid + 1, se, n * 2 + 2);

        segmentTree[n] = leftMin + rightMin;
        return segmentTree[n];
    }

    public int getSumInRange(int rs, int re, int n) {
        if (rs < 0 || re > n || rs > re) {
            System.out.println("Invalid input");
            return -1;
        }

        return getSumInRangeUtil(
            this.segmentTree,
            0, n - 1, rs, re, 0);
    }

    public int getSumInRangeUtil(
        int [] segmentTree, 
        int segmentStart, 
        int segmentEnd, 
        int rs, 
        int re,
        int node) 
    {
        System.out.println("rs: " + rs + ", re: " + re + ", segSt: " + segmentStart + ", segEnd: " + segmentEnd + ", node: " + node);
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

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6};
        int n = arr.length;
        SegmentTree segTree = new SegmentTree(arr, n);
        
        segTree.printSegmentTree();
        System.out.println();
        System.out.println(segTree.getSumInRange(0, 5, 6));
    }
}