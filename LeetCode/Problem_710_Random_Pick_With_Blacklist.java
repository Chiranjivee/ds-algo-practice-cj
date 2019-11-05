class Solution {

    int n;
    int[] b;
    Random r;

    public Solution(int N, int[] blacklist) {
        n = N;
        Arrays.sort(blacklist);
        b = blacklist;
        r = new Random();
    }

    public int pick() {
        int k = r.nextInt(n - b.length);
        int lo = 0;
		int hi = b.length - 1;

		while (lo < hi) {
			int i = (lo + hi + 1) / 2;
			if (b[i] - i > k) hi = i - 1;
			else lo = i;
		}
		return lo == hi && b[lo] - lo <= k ? k + lo + 1 : k;
    }
}
