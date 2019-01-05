class Power {
    public static int power(int x, int n) {
        if (n == 0) return 1;
		if (n == 1) return x;

        return 
            (n % 2 == 0) ?
                power(x * x, n / 2) :
                x * power(x, n - 1);
	}
    public static void main(String[] args) {
        System.out.println("Power(2, 1): " + power(2, 1));
    }
}
