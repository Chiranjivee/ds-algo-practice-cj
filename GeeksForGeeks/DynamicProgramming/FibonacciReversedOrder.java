class FibonacciReversedOrder {
    public void printFibReverse(int n) {
        int [] fib = new int[n + 1];
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 2] + fib[i - 1];
        }

        for (int i = n; i >= 0; i--) {
            System.out.print(fib[i] + " ");
        }
    }
}
