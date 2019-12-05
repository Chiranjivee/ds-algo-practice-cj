import java.io.*;
class FibonacciWithTwoVariables {

    static void fib(int n) {
        int a = 0, b = 1, c;
        if (n >= 0) {
            System.out.print(a + " ");
        }

        if (n >= 1) {
            System.out.print(b + " ");
        }
            
        for (int i = 2; i <= n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        fib(9);
    }
}
