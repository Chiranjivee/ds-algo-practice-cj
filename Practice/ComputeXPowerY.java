class XPowerY {
    public static double powerIter(int x, int y) { // 8
        double result = 1;
        while (y > 0) { // 6 > 0 3
            if ((y & 1) > 0) {
                result *= x; // 25
            }

            y = y >> 1;
            x = x * x;
        }

        return result;
    }

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
        System.out.println(XPowerY.powerIter(5, 6));
    }
}

// 2^5 = 2 ^ 2