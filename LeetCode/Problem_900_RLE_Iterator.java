/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
class RLEIterator {

    int[] A;
    int i, q;

    public RLEIterator(int[] A) {
        this.A = A;
        i = q = 0;
    }

    public int next(int n) {
        while (i < A.length) {
            if (q + n > A[i]) {
                n -= A[i] - q;
                q = 0;
                i += 2;
            } else {
                q += n;
                return A[i+1];
            }
        }

        return -1;
    }
}
