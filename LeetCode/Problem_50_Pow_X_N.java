class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }
        
        if (n == -1) {
            return 1 / x;
        }
        
        double temp = x * x;
        int option1 = myPow(temp, n / 2);
        if (n % 2 == 0) {
            return option1;
        } else {
            return option1 * (n > 1 ? x : (1 / x));
        }
    }
}
