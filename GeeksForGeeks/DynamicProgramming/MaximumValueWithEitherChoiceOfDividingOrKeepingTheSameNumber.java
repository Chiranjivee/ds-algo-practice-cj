class Solution {
    public int breakNaive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return Math.max(breakNaive(n / 2) + breakNaive(n / 3) + breakNaive(n / 4) + breakNaive(n / 5), n);
    }
}
