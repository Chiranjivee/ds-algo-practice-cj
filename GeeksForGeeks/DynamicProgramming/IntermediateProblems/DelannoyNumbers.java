/**
 * In mathematics, a Delannoy number D describes the number of paths from the southwest corner (0, 0) of a rectangular grid 
 * to the northeast corner (m, n), using only single steps north, northeast, or east.
 */
class DelannoyNumbers {
    public int getDelannoyNumber(int m, int n) {
        if (n == 0 || m == 0) {
            return 1;
        }

        return getDelannoyNumber(m - 1, n) + getDelannoyNumber(m - 1, n - 1) + getDelannoyNumber(m, n - 1);
    }
}
