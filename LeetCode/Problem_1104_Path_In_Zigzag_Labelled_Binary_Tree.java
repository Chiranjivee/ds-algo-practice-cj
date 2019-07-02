class Solution {
    public List<Integer> pathInZigZagTree(int label) {
		List<Integer> result = new LinkedList<Integer>();
		result.add(label);
        int height = findHeight(label);
		while (label != 1) {
			int parent = label / 2;
			--height;
			int start = (int) (Math.pow(2, height));
			int end = start + (int) (Math.pow(2, height)) - 1;
			label = start + (end - parent); // reverse index
			result.add(0, label);
		}
		return result;
	}

	int findHeight(int n) {
		int height = 0;
		while (n != 1) {
			n = n / 2;
			height++;
		}
		return height;
	}
}
