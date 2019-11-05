class MinSegmentTree {
    int segTreeSize;
    int arrSize;
    int[] segTree;

    MinSegmentTree(int [] arr) {
        int length = arr.length;
        this.arrSize = length;
        int height = (int) Math.ceil(Math.log(length)/ Math.log(2));
        this.segTreeSize =  2 * (int) Math.pow(2, height) - 1;
        System.out.println("SegTree Size: " + segTreeSize);
        this.segTree = new int[this.segTreeSize];
        constructSegmentTree(arr, 0, arr.length - 1, 0);
    }

    int constructSegmentTree(int [] arr, int start, int end, int nodeIdx) {
        System.out.println("Start: " + start + " End: " + end + " nodeIdx: " + nodeIdx);
        if (start == end) {
            segTree[nodeIdx] = arr[start];
            return segTree[nodeIdx];
        }

        int mid = start + (end - start) / 2;

        int leftMin = constructSegmentTree(arr, start, mid, nodeIdx * 2 + 1);
        int rightMin = constructSegmentTree(arr, mid + 1, end, nodeIdx * 2 + 2);

        segTree[nodeIdx] = Math.min(leftMin, rightMin);
        return segTree[nodeIdx];
    }

    int getMinInRange(int rangeStart, int rangeEnd) throws Exception {
        if (rangeStart < 0 || rangeStart >= arrSize ||
            rangeEnd < 0 || rangeEnd > arrSize) {
                throw new Exception("Un-expected range queried.");
            }

        return getMinInRangeUtil(rangeStart, rangeEnd, 0, arrSize - 1, 0);
    }

    int getMinInRangeUtil(int rangeStart, int rangeEnd, int segmentStart, int segmentEnd, int nodeIdx) {
        if (rangeStart == segmentStart && rangeEnd == segmentEnd) {
            return segTree[nodeIdx];
        }

        if (segmentEnd < rangeStart || rangeEnd < segmentStart) {
            return Integer.MAX_VALUE;
        }

        if (segmentStart == segmentEnd) {
            return segTree[nodeIdx];
        }

        int mid = (segmentStart + segmentEnd) / 2;
        int leftMin = getMinInRangeUtil(rangeStart, rangeEnd, segmentStart, mid, nodeIdx * 2 + 1);
        int rightMin = getMinInRangeUtil(rangeStart, rangeEnd, mid + 1, segmentEnd, nodeIdx * 2 + 2);

        return Math.min(leftMin, rightMin);
    }


    public static void main(String[] args) throws Exception {
        int [] inputArr = { 11, 22, 33, 44, 55 };
        MinSegmentTree segmentTree = new MinSegmentTree(inputArr);
        int result = segmentTree.getMinInRange(0, inputArr.length - 1);
        System.out.println("Minimum in range (0, 4): " + result);
        result = segmentTree.getMinInRange(3, 4);
        System.out.println("Minimum in range (3, 4): " + result);
    }
}
