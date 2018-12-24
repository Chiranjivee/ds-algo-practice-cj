class SteppingStairs {


    static int steps(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        return steps(n - 1) + steps(n - 2) + steps(n - 3);
    }


    public static void main(String[] args) {
        System.out.println(steps(2));
    }
}