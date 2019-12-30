/**
 * In combinatorics, the Eulerian Number A(n, m), is the number of permutations of the numbers 
 * 1 to n in which exactly m elements are greater than previous element
 * 
 */
class EulerianNumber {
    int eulerian(int n, int m) {
        if (m >= n || n == 0) {
            return 0;
        }

        if (m == 1) {
            return 0;
        }

        return 
            (n - m) * eulerian(n - 1, m - 1) + 
            (m + 1) * eulerian(n - 1, m);
    }
}
