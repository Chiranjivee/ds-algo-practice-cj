class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) return new int[0];
        int[] result = new int[2];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(new MyComparator());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int cur = nums.get(i).get(0);
            minHeap.offer(new Cell(i, 0, cur));
            max = Math.max(max, cur);
        }
        int range = Integer.MAX_VALUE;
        while (true) {
            Cell tmp = minHeap.poll();
            int start = tmp.val;
            int end = max;
            if (end - start < range) {
                range = end - start;
                result[0] = start;
                result[1] = end;
            }
            
            if (tmp.col + 1 < nums.get(tmp.row).size()) {
                int nextVal = nums.get(tmp.row).get(tmp.col + 1);
                Cell next = new Cell(tmp.row, tmp.col + 1, nextVal);
                max = Math.max(max, nextVal);
                minHeap.offer(next);
            } else {
                break;
            }
        }
        return result;
    }
    static class Cell{
        private int row;
        private int col;
        private int val;
        Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    static class MyComparator implements Comparator<Cell> {
        @Override
        public int compare(Cell c1, Cell c2) {
            return Integer.compare(c1.val, c2.val);
        }
    }
}
