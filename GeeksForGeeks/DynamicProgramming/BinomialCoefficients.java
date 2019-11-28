/**
 * 
 * Binomail coefficient C(n, k) means number of ways to select k items out of n items.
 * One simple way to understand the solution is the equation
 * C(n, k) = 
 *      C(n - 1, k - 1)  * When you select the current item, the problem reduces to this sub problem 
 *      + C(n - 1, k)    * When you don't select the current item, the problem reduces to this sub problem
 */
public class BinomialCoefficients {

    public void naiveBinomialCoeficient(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }

        return naiveBinomialCoeficient(n - 1, k - 1) + naiveBinomialCoeficient(n - 1, k);
    }

    public static void main(String[] args) {
        System.out.println("Naive way of C(5, 2): " + naiveBinomialCoeficient(5, 2));
    }
}
