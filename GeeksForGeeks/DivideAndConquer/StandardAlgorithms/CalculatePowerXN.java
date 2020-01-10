class CalculatePower {
    public power(int x, int n) {
        if (n == 1) {
            return x;
        }

        if (n % 2 == 0) {
            int temp = power(n / 2);
            return temp * temp;
        } else {
            int temp = power((n - 1) / 2);
            return x * temp * temp;
        }
    }
}
