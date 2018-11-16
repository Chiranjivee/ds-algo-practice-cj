class StringToInt {
    public static String intToString(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }

        StringBuilder result = new StringBuilder();
        while (x >= 0) {
            result.append(x % 10);
            x /= 10;
            if (x == 0) break;
        }

        if (isNegative) result.append("-");
        return result.reverse().toString();
    }

    public static void main(String [] args) {
        System.out.println(intToString(-102));
        System.out.println(intToString(0));
        System.out.println(intToString(10));
        System.out.println(intToString(99));
        System.out.println(intToString(0));
        System.out.println(intToString(-12));
    }
}