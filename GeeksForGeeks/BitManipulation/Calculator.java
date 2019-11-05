class Calculator {
    /**
     * Calculate x - y
     */
    public static int subtract(int x, int y) {
        if (y == 0) {
            return x;
        }

        int minus = x ^ y;
        int borrow = (~x & y) << 1;
        System.out.println("Borrow: " + borrow);
        

        return subtract(minus, borrow);
    }

    public static int add(int x, int y) {
        if (y == 0) {
            return x;
        }

        int sum = x ^ y;
        int carry = (x & y) << 1;
        return add(sum, carry);
    }

    public static void main(String[] args) {
        System.out.println(subtract(3, 4));
    }
}


