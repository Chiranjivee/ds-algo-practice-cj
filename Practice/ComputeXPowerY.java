class XPowerY {
    public static double power(int x, int y) {
        if (y == 0) {
            return 1;
        }

        if (y == 1) {
            return x; 
        }

        double temp = power(x, y / 2);
        temp *= temp;
        if (y % 2 != 0) { 
            temp = (y > 0) ? temp * x : temp / x;
        } 

        return temp;
    }
    public static void main(String[] args) {
        System.out.println(XPowerY.power(2, -3));
        System.out.println(XPowerY.power(2, 10));
        System.out.println(XPowerY.power(4, 3));
        System.out.println(XPowerY.power(3, 4));
    }
}

// 2^5 = 2 ^ 2