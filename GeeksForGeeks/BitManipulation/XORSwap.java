class XORSwap {

    public static int xor(int a, int b) {
        return a ^ b;
    }
    public static void main(String[] args) {
        int a = 5;
        int b = 6;

        System.out.println("A: " + a + ", B: " + b);
        // a = 1 b = 0;
        a = xor(a, b); // 1
        b = xor(a, b); // 1
        a = xor(a, b); // 0

        System.out.println("A: " + a + ", B: " + b);
    }
}