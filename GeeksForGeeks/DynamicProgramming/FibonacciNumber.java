class Fibonacci {

    public double ONE_PLUS_SQR_ROOT_FIVE_BY_TWO = (1 + Math.sqrt(5)) / 2;

    public int getNthFibonacciNumber(int n) {
        return (int) Math.round(Math.pow(ONE_PLUS_SQR_ROOT_FIVE_BY_TWO, n) / Math.sqrt(5));
    }
}
