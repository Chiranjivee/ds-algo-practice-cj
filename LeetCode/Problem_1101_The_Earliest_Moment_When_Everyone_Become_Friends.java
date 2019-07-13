class Solution {
    public int earliestAcq(int[][] logs, int N) {
		Arrays.sort(logs, (l1, l2) -> l1[0] - l2[0]);
		UnionFind uf = new UnionFind(N);
		for (int[] log : logs) {
			uf.union(log[1], log[2]);
			if (uf.getSetCount() == 1)
				return log[0];
		}
		return -1;
	}

	public class UnionFind {
		private int[] id;
		private int[] size;
		private int setCount;
		private int maxSetSize;

		public UnionFind(int n) {
			id = new int[n];
			size = new int[n];
			for (int i = 0; i < n; i++) {
				id[i] = i; // self-loop
				size[i] = 1;
			}
			setCount = n;
			maxSetSize = 1;
		}

		// O(logN)
		public void union(int i, int j) {
			int ri = root(i);
			int rj = root(j);
			if (ri == rj)
				return;
			if (size[ri] >= size[rj]) {
				id[rj] = id[ri];
				size[ri] += size[rj];
				maxSetSize = Math.max(maxSetSize, size[ri]);
			} else {
				id[ri] = id[rj];
				size[rj] += size[ri];
				maxSetSize = Math.max(maxSetSize, size[rj]);
			}
			setCount--;
		}

		// O(logN)
		public boolean find(int i, int j) {
			return root(i) == root(j);
		}

		public int getMaxSetSize() {
			return maxSetSize;
		}

		public int getSetCount() {
			return setCount;
		}

		private int root(int i) {
			while (id[i] != i) { // keep checking for the self-loop
				id[i] = id[id[i]]; // set grand-parent as parent (path compression)
				i = id[i]; // go up to parent
            }

			return i;
		}
	}
}
